package com.test.selenium.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;


	@BeforeTest
	// Parameter will get browser from testng.xml on which browser test to run
	@Parameters("myBrowser")
	public void getBrowser(String myBrowser) {
		if (System.getProperty("os.name").contains("Window")) {
			if (myBrowser.equalsIgnoreCase("firefox")) {
				// https://github.com/mozilla/geckodriver/releases
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
		
			} else if (myBrowser.equalsIgnoreCase("chrome")) {
				// https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
			if (myBrowser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			
			} else if (myBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
				
			}
		}
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
