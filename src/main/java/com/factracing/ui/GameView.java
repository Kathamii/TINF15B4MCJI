package com.factracing.ui;


import com.factracing.beans.GameRoom;
import com.factracing.components.ChatComponent;
import com.factracing.components.GameQuestionComponent;
import com.factracing.components.GameStatusComponent;
import com.factracing.database.DatabaseController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameView.VIEW_NAME)
public class GameView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameView";
	DatabaseController databaseController = new DatabaseController();


	public GameView()
	{
		setMargin(true);
		setDefaultComponentAlignment(Alignment.TOP_LEFT);
		setWidth("100%");
	}


	/**
	 * Initializes layout on each enter.
	 */
	private void initializeLayout()
	{
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);

		HorizontalLayout gameFieldLayout = createNewGameFieldLayout();

		addComponents(factRacingLabel, gameFieldLayout);
		setComponentAlignment(factRacingLabel, Alignment.MIDDLE_CENTER);
	}


	/**
	 * The top half of the layout that has all the game related stuff.
	 *
	 * @return
	 */
	private HorizontalLayout createNewGameFieldLayout()
	{
		HorizontalLayout gameFieldLayout = new HorizontalLayout();
		gameFieldLayout.setSizeFull();

		GameRoom room = ((FactRacingUI) UI.getCurrent()).getUserSession().getCurrentGameRoom();
		
		GameStatusComponent status = new GameStatusComponent(room.getGame());
		GameQuestionComponent question = new GameQuestionComponent(room.getGame());
		ChatComponent chat = new ChatComponent(room, "420px");

		gameFieldLayout.addComponents(status, question, chat);

		// make sure that the question part gets the most space available
		gameFieldLayout.setExpandRatio(status, 1.25f);
		gameFieldLayout.setExpandRatio(question, 1.5f);
		gameFieldLayout.setExpandRatio(chat, 1.25f);

		return gameFieldLayout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		initializeLayout();
	}

}
