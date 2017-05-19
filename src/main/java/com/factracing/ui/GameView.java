package com.factracing.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;


@SpringView(name = GameView.VIEW_NAME) 
public class GameView implements View
{
	
	public static final String VIEW_NAME = "gameView";

	@Override
	public void enter(ViewChangeEvent event)
	{

	}

}
