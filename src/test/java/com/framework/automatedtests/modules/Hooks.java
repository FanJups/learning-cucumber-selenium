package com.framework.automatedtests.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/*
 *  configure actions to be run before and after scenario
 * */

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();

    }

    @After
    public void tearDown() {

	driver.quit();

    }

}
