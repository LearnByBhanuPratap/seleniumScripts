package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends BaseClass{
	

	
	@Test
	public void testLogin(){
		getDriver().get("https://www.facebook.com/");
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		getDriver().findElement(By.xpath("//*[@id='form']/div/div[4]/input")).sendKeys("password");
		getDriver().findElement(By.id("submitButton")).click();
	}

}
