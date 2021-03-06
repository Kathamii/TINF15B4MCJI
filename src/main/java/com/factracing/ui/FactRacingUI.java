package com.factracing.ui;


import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Configuration;

import com.factracing.beans.UserSession;
import com.factracing.components.EndscreenWindow;
import com.factracing.database.DataHandler;
import com.factracing.database.DataHandlerListener;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;


@Theme("valo")
@SpringUI
@PreserveOnRefresh
public class FactRacingUI extends UI implements DataHandlerListener
{

	private Navigator navigator;
	private UserSession user;
	private static final int UI_POLLING_RATE = 500;

	private static final String SESSION_COOKIE_ID = "FactRacingUsernameCookie";


	@Configuration
	@EnableVaadin
	public static class MyConfiguration
	{
	}


	@Override
	protected void init(VaadinRequest vaadinRequest)
	{
		// get the potential gameroom id from the uri
		String uri = getPage().getUriFragment();

		getPage().setTitle("Fact Racing");
		setPollInterval(UI_POLLING_RATE);

		navigator = new Navigator(this, this);
		setNavigator(navigator);
		user = new UserSession();
		updateUserSessionData();
		DataHandler.addUserToList(user);
		DataHandler.register(this);
		if (DataHandler.doesRoomExist(uri))
			user.setCurrentGameRoom(DataHandler.getRoomByID(uri));

		navigator.addView(WelcomeView.VIEW_NAME, new WelcomeView());
		navigator.addView(MainNavigationView.VIEW_NAME, new MainNavigationView());
		navigator.addView(CreateGameRoomView.VIEW_NAME, new CreateGameRoomView());
		navigator.addView(GameRoomView.VIEW_NAME, new GameRoomView());
		navigator.addView(GameView.VIEW_NAME, new GameView());

		navigator.navigateTo(WelcomeView.VIEW_NAME);
	}


	public UserSession getUserSession()
	{
		return user;
	}


	private void updateUserSessionData()
	{
		Cookie sessionCookie = retrieveSessionCookie();
		if (sessionCookie != null)
			user.setUserName(sessionCookie.getValue());
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


	private Cookie getCookieByName(String name)
	{
		Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
		for (Cookie cookie : cookies)
		{
			if (name.equals(cookie.getName()))
				return cookie;
		}
		return null;
	}


	@Override
	public void switchView(String viewName)
	{
		access(new Runnable() {

			@Override
			public void run()
			{
				getNavigator().navigateTo(viewName);
			}
		});
	}


	@Override
	public void showWindow(Window window)
	{
		access(new Runnable() {

			@Override
			public void run()
			{
				UI.getCurrent().addWindow(window);
			}
		});
	}

}
