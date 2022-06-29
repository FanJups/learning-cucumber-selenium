package com.framework.automatedtests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

	strict = true, 
	plugin = { "pretty", "json:target/json/results.json" }, 
	features = {
		"src/test/java/com/framework/automatedtests" }, 
	glue = { "" }, 
	tags = { "" })
public class AppTest {

}
