package com.factracing.components;


import com.factracing.beans.Game;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


public class GameStatusComponent extends VerticalLayout
{
	
	private Game game;

	public GameStatusComponent(Game game)
	{
		this.game = game;
		setSizeFull();

		Panel gamePanel = new Panel("Status");
		gamePanel.setSizeFull();

		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setSizeFull();

		Label placeHolderLabel = new Label("");
		placeHolderLabel.setHeight("420px");
		panelContent.addComponent(placeHolderLabel);

		gamePanel.setContent(panelContent);

		addComponent(gamePanel);
	}

}
