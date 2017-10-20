package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteLeads {
	
WebDriver driver;
	
	@Test
	public void testDeleteLeads(){
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
		
		driver.findElement(By.xpath("//a[contains(text(),'Bhanu Pratap') and @title='Leads']/parent::td/following-sibling::td[6]/a[2]")).click();
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
	}

}
