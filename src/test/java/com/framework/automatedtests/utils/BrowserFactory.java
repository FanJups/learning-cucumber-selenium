package com.framework.automatedtests.utils;

import static com.framework.automatedtests.utils.PropertiesFile.read;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * configure browsers
 **/
public class BrowserFactory {

    static WebDriver factoryDriver;

    private static HashMap<String, String> configurationMap = read("src/test/resources/environment/config.properties");

    static String webBrowserType = configurationMap.get("browser");

    static boolean isheadless = Boolean.parseBoolean(configurationMap.get("isheadless"));

    public static WebDriver getFactoryDriver() {
    	
    	String driverPath="src/test/resources/drivers/";

	switch (webBrowserType) {

	case "chrome":

	    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

	    /*
	     * Command Line Switches
	     *
	     * https://chromium.googlesource.com/chromium/src/+/master/chrome/common/
	     * chrome_switches.cc
	     *
	     * https://peter.sh/experiments/chromium-command-line-switches/
	     *
	     *
	     *
	     */

	    ChromeOptions options = new ChromeOptions();

	    options.addArguments("--start-maximised");

	    options.addArguments("--ignore-certificate-errors");

	    options.addArguments("--disable-popup-blocking");

	    options.addArguments("--incognito");

	    /*
	     * Whether the browser will run in background or not
	     *
	     */

	    options.setHeadless(isheadless);

	    factoryDriver = new ChromeDriver(options);

	    break;

	case "ie":
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		
		factoryDriver= new InternetExplorerDriver();

	    break;
	    
	case "firefox":
	    break;

	default:
	    break;

	}

	return factoryDriver;
    }

}
