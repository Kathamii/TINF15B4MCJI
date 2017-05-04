package com.factracing.cucumber;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by janik on 04/12/2016.
 */

public class MyStepdefs {


    @Given("^Session with Name$")
    public void sessionWithName() throws Throwable {
        //Move
        String chromeDriverLocation = "SeleniumChrome/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        //
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/");
        assertTrue(chrome.getTitle().equals("The Internet"));
        chrome.quit();
        //throw new PendingException();
    }

    @Given("^Session$")
    public void session() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
