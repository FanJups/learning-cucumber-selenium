package com.framework.automatedtests.stepdefinition;

import static com.framework.automatedtests.modules.Hooks.driver;
import static com.framework.automatedtests.pageobjects.GoogleSearchPage.searchFor;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDefinition {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {

	driver.get("https://www.google.com/");
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String string) {
	searchFor(string);

    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String string) {

	assertTrue(driver.getTitle().contains(string));

    }

}
