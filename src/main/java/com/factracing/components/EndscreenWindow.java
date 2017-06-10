package com.factracing.components;


import java.util.List;

import com.factracing.beans.Game;
import com.factracing.beans.UserSession;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class EndscreenWindow extends Window
{

	private Game game;


	public EndscreenWindow(Game game)
	{
		super("Endscreen");
		this.game = game;

		setWidth("30%");
		setHeight("50%");
		setResizable(false);
		center();
		setModal(true);

		initializeLayout();
	}


	private void initializeLayout()
	{
		VerticalLayout layout = new VerticalLayout();
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label leaderboardLabel = new Label("<h2>Leaderboard<h2>", ContentMode.HTML);
		layout.addComponent(leaderboardLabel);

		VerticalLayout leaderboardLayout = new VerticalLayout();
		leaderboardLayout.setWidth("75%");
		leaderboardLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);
		List<UserSession> leaderboard = game.getLeaderboard();
		for (int i = 0; i < leaderboard.size(); i++)
		{
			Label label = new Label("<h4>" + (i + 1) + ": " + leaderboard.get(i).getUserName() + " (Correct questions: "
					+ game.getCorrectQuestionsCount(leaderboard.get(i)) + ")</h4>", ContentMode.HTML);
			leaderboardLayout.addComponent(label);
		}

		Button okButton = new Button("OK");
		okButton.setWidth("150px");
		okButton.setId("okButton");
		okButton.setClickShortcut(KeyCode.ENTER, 0);
		okButton.addClickListener(ev -> {
			close();
		});

		layout.addComponents(leaderboardLayout, okButton);

		setContent(layout);
	}

}
