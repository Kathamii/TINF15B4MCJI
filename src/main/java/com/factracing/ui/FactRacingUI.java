package com.factracing.ui;


import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Configuration;

import com.factracing.beans.UserSession;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;


@Theme("valo")
@SpringUI
public class FactRacingUI extends UI
{

	private Navigator navigator;

	private UserSession user;

	private static final String SESSION_COOKIE_ID = "FactRacingUsernameCookie";


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
		user = new UserSession();
		updateUserSessionData();

		navigator.addView(WelcomeView.VIEW_NAME, new WelcomeView());
		navigator.addView(MainNavigationView.VIEW_NAME, new MainNavigationView());
		navigator.addView(CreateGameRoomView.VIEW_NAME, new CreateGameRoomView());
		navigator.addView(GameRoomView.VIEW_NAME, new GameRoomView());

		navigator.navigateTo(WelcomeView.VIEW_NAME);
		setNavigator(navigator);
	}


	public UserSession getUserSession()
	{
		return user;
	}


	private void updateUserSessionData()
	{
		Cookie sessionCookie = retrieveSessionCookie();
		if (sessionCookie != null) {
			user.setUserName(sessionCookie.getValue());
			return;
		}
	}


	protected void updateUserSessionCookie(String username)
	{
		Cookie sessionCookie = retrieveSessionCookie();
		if (sessionCookie == null)
			sessionCookie = new Cookie(SESSION_COOKIE_ID, username);
		sessionCookie.setPath("/");
		sessionCookie.setValue(username);
		sessionCookie.setMaxAge(60 * 60 * 24 * 30); // valid for 30 days
		VaadinService.getCurrentResponse().addCookie(sessionCookie);
		user.setUserName(username);
	}


	private Cookie retrieveSessionCookie()
	{
		return getCookieByName(SESSION_COOKIE_ID);
	}


	private static Cookie getCookieByName(String name)
	{
		Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
		for (Cookie cookie : cookies)
		{
			if (name.equals(cookie.getName()))
				return cookie;
		}
		return null;
	}
}
