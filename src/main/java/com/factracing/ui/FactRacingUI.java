package com.factracing.ui;


import org.springframework.context.annotation.Configuration;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Main;


@Theme("valo")
@SpringUI
public class FactRacingUI extends UI
{

	public static Navigator navigator;


	@Configuration
	@EnableVaadin
	public static class MyConfiguration
	{
	}


	@Override
	protected void init(VaadinRequest vaadinRequest)
	{
		getPage().setTitle("Fact Racing");
		
		navigator = new Navigator(this, this);
		
		navigator.addView("", new WelcomeView());
		navigator.addView("mainNav", new MainNavigationView());
		
		navigator.navigateTo("");
	}
}
