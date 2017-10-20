package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeads {
	
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
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		select.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bhanu Pratap");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("learnByBhanu");
		driver.findElement(By.xpath("//input[@name='designation']")).sendKeys("youTube");
		WebElement LeadSource = driver.findElement(By.name("leadsource"));
		select = new Select(LeadSource);
		select.selectByVisibleText("Employee");
		
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		select = new Select(industry);
		select.selectByVisibleText("Chemicals");
		
		driver.findElement(By.name("annualrevenue")).sendKeys("100000");
		driver.findElement(By.id("noofemployees")).sendKeys("100");
		driver.findElement(By.xpath("//*[@id='secondaryemail']")).sendKeys("leanrbybhnau@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='lane']")).sendKeys("Bihar Muzaffarpur");
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys("560078");
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("this is automation");
		
		driver.findElement(By.id("phone")).sendKeys("9999999999");
		driver.findElement(By.id("mobile")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("leanrbybhnau@gmail.com");
		
		WebElement leadstatus = driver.findElement(By.name("leadstatus"));
		select = new Select(leadstatus);
		select.selectByVisibleText("Contact in Future");
		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
