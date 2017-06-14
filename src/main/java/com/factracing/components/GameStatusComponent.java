package com.factracing.components;


import com.factracing.beans.Card;
import com.factracing.beans.Game;
import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.database.DataHandler;
import com.factracing.game.GameListener;
import com.factracing.ui.FactRacingUI;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class GameStatusComponent extends VerticalLayout implements GameListener
{

	private GameRoom room;
	private Game game;
	private Label remainingTimeLabel;
	private Label questionsAnswered;
	private UserSession currentUser;
	private Button startGameButton;
	private Button leaveGameButton;


	public GameStatusComponent(GameRoom room)
	{
		this.room = room;
		game = room.getGame();
		game.register(this);

		setSizeFull();

		Panel statusPanel = new Panel("Status");
		statusPanel.setWidth("355px");

		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setSizeFull();

		remainingTimeLabel = new Label("<h3>Remaining Time: 0:00</h3>", ContentMode.HTML);
		updateRemainingTimeLabel(game.getRemainingTime());
		
		questionsAnswered = new Label("<h3>Answered Questions: 0</h3><br>", ContentMode.HTML);

		startGameButton = createStartGameButton();
		leaveGameButton = createLeaveGameButton();

		panelContent.addComponents(remainingTimeLabel, questionsAnswered, startGameButton, leaveGameButton);
		panelContent.setComponentAlignment(startGameButton, Alignment.MIDDLE_CENTER);
		panelContent.setComponentAlignment(leaveGameButton, Alignment.MIDDLE_CENTER);

		statusPanel.setContent(panelContent);

		addComponents(new PlayerList("Players", room), statusPanel);
	}


	private Button createStartGameButton()
	{
		Button startGameButton = new Button("Start");
		startGameButton.setWidth("150px");
		startGameButton.setId("startGameButton");
		startGameButton.addClickListener(event -> {
			game.start();
			startGameButton.setEnabled(false);
		});

		currentUser = ((FactRacingUI) UI.getCurrent()).getUserSession();
		startGameButton.setEnabled(room.getCreator().equals(currentUser));

		return startGameButton;
	}


	private Button createLeaveGameButton()
	{
		Button leaveGameButton = new Button("Leave");
		leaveGameButton.setWidth("150px");
		leaveGameButton.setId("leaveGameButton");
		leaveGameButton.addClickListener(event -> {
			DataHandler.removeUserFromGameRoom(currentUser, room);
		});
		leaveGameButton.setVisible(false);

		return leaveGameButton;
	}


	private void updateRemainingTimeLabel(long remainingTime)
	{
		int totalSeconds = (int) (remainingTime / 1000);
		int minutes = totalSeconds / 60;
		int seconds = totalSeconds % 60;
		
		String additionalZero = seconds < 10 ? "0" : "";

		remainingTimeLabel.setValue("<h3>Remaining Time: " + minutes + ":" + additionalZero + seconds + "</h3>");
	}


	private void updateAnsweredQuestionsCount(int answeredQuestionsCount)
	{
		questionsAnswered.setValue("<h3>Answered Questions: " + answeredQuestionsCount + "</h3><br>");
	}


	@Override
	public void remainingTimeUpdate(long remainingTime)
	{
		updateRemainingTimeLabel(remainingTime);
		updateAnsweredQuestionsCount(game.getAnsweredQuestionsCount(currentUser));
	}


	@Override
	public void gameStart(Card question)
	{
		updateRemainingTimeLabel(game.getRemainingTime());
		updateAnsweredQuestionsCount(0);
		leaveGameButton.setVisible(false);
	}


	@Override
	public void gameEnd()
	{
		updateRemainingTimeLabel(game.getRemainingTime());
		updateAnsweredQuestionsCount(0);
		startGameButton.setEnabled(room.getCreator().equals(currentUser));
		leaveGameButton.setVisible(true);
	}

}
