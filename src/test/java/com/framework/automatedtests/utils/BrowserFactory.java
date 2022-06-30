package com.framework.automatedtests.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * configure browsers
 * **/
public class BrowserFactory {

    static WebDriver factoryDriver;

    private static HashMap<String, String> configurationMap = PropertiesFile
	    .read("src/test/resources/environment/config.properties");

    static String webBrowserType = configurationMap.get("browser");

    public static WebDriver getFactoryDriver() {

	switch (webBrowserType) {

	case "chrome":
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    factoryDriver = new ChromeDriver();
	    break;
	case "ie":
	    break;
	case "firefox":
	    break;

	default:
	    break;

	}

	return factoryDriver;
    }

}
