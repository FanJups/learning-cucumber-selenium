package com.framework.automatedtests.modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.automatedtests.pageobjects.GoogleSearchPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/*
 *  configure actions to be run before and after scenario
 * */

public class Hooks {

    public static WebDriver driver;

    private GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();

    @Before
    public void setUp() {

	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();

	/*
	 * Without this line, it's not sure that the search button will be clicked.
	 * Sometimes it works, sometimes not. When not working, we get
	 * ElementNotInteractableException. After trying to figure out, I got this
	 * solution
	 *
	 * https://stackoverflow.com/questions/45183797/element-not-interactable-
	 * exception-in-selenium-web-automation
	 */
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	PageFactory.initElements(driver, googleSearchPageObject);

    }

    @After
    public void tearDown() {

	driver.quit();

    }

}
