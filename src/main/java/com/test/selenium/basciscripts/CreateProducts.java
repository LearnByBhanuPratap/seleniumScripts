package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateProducts {
	
	WebDriver driver;
	
	@Test
	public void testCreateLeads(){
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
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Bhanu Pratap");
		driver.findElement(By.id("jscal_trigger_sales_start_date")).click();
		String monthyear = driver.findElement(By.xpath("//td[@style='cursor: move;' and @class='title']")).getText();
		WebElement navigate = driver.findElement(By.xpath("//tr[@class='headrow']/td[4]"));
		//td[contains(text(),'12')]
	}

}
