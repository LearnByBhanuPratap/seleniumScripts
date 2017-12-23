package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FacebookLogin extends BaseClass{
	

	
	@Test
	public void testLogin(){
		getDriver().get("https://www.facebook.com/");
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getDriver().findElement(By.id("email")).sendKeys("admin");
		getDriver().findElement(By.id("pass")).sendKeys("password");
	}

}
