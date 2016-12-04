package com.factracing;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by janik on 04/12/2016.
 */
public class SiteTest {
    @BeforeClass
    public static void setupChromeDriverLocation()
    {
        String chromeDriverLocation = "SeleniumChrome/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
    }

    @Test
    public void basicChromeUsage()
    {
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/");
        assertTrue(chrome.getTitle().equals("The Internet"));
        chrome.quit();
    }
}
