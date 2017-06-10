package com.factracing.components;


import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


public class GameStatusComponent extends VerticalLayout
{

	public GameStatusComponent()
	{
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
