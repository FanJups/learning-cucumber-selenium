package com.framework.automatedtests.modules;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

	strict = true, plugin = { "pretty", "json:target/json/results.json" }, features = {
		"src/test/resources/features" }, glue = { "com.framework.automatedtests.modules",
			"com.framework.automatedtests.stepdefinition" }, tags = { "" })
public class TestRunner {

    // TODO: Create test run configuration

}
