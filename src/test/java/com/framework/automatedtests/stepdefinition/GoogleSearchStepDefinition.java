package com.framework.automatedtests.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDefinition {

    WebDriver driver;

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {

	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.google.com/");
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String string) {

	driver.findElement(By.name("q")).clear();
	driver.findElement(By.name("q")).sendKeys(string);

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

	driver.findElement(By.name("btnK")).click();

    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String string) {

	assertTrue(driver.getTitle().contains(string));

	driver.quit();

    }

}
