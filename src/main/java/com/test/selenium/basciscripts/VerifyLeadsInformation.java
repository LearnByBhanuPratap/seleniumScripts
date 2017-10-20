package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLeadsInformation {
	
	WebDriver driver;
	
	@Test
	public void testVerifyLeadsInformation(){
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		//window
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		driver.get("http://172.16.125.9:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='form']/div/div[4]/input")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Bhanu Pratap")).click();
		
		String fName = driver.findElement(By.id("mouseArea_First Name")).getText();
		Assert.assertEquals(fName, "Mr.   Bhanu Pratap");
		
		String cName = driver.findElement(By.id("dtlview_Company")).getText();
		Assert.assertEquals(cName, "learnByBhanu");
		
		String cmount = driver.findElement(By.id("mouseArea_Annual Revenue")).getText();
		
		Assert.assertEquals(cmount.substring(2), "100,000");
		
	}

}
