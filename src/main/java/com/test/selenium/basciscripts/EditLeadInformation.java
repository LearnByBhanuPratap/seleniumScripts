package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditLeadInformation {
	
    WebDriver driver;
	
	@Test
	public void testEditLeadInformation(){
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		//window
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		driver.get("http://172.16.125.9:8888/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Enter user Name
		driver.findElement(By.xpath("//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		// Enter Password
		driver.findElement(By.xpath("//*[@id='form']/div/div[4]/input")).sendKeys("password");
		// Click on submit button
		driver.findElement(By.id("submitButton")).click();
		// Click on leads
		driver.findElement(By.linkText("Leads")).click();
		// Click on lead edit button
		driver.findElement(By.xpath("//a[contains(text(),'Elizabeth') and @title='Leads']/parent::td/following-sibling::td[6]/a[1]")).click();
		// click old country Data
		driver.findElement(By.xpath("//input[@name='country']")).clear();
		// Enter India as country
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
		// Click on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// click again on lead link
		driver.findElement(By.linkText("Elizabeth")).click();
		// get text of country
		String cName = driver.findElement(By.id("mouseArea_Country")).getText();
		
		// verify through assertion
		Assert.assertEquals(cName.substring(2), "India");
		
		
	}

}
