package com.factracing.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = ManualView.VIEW_NAME)
public class ManualView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "manualView";


	public ManualView()
	{
	}


	@Override
	public void enter(ViewChangeEvent event)
	{

	}

}
