package com.test.selenium.basciscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToReadTableColumnData {
	
    WebDriver driver;
	
	@Test
	public void testHowToReadTableColumnData(){
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

		int rowCount = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr")).size();
		System.out.println(rowCount);
		int colCount = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[3]/td")).size();
		System.out.println(colCount);
		for(int i = 3 ; i<=rowCount; i++){
			for(int j = 1 ; j<colCount; j++){
				
				//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[4]/td[4]
				
				String fPart = "//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[";
				String sPart = "]/td[";
				String tPart = "]";
				
				//System.out.println(fPart+i+sPart+j+tPart);
				
				String colData = driver.findElement(By.xpath(fPart+i+sPart+j+tPart)).getText();
				System.out.print(colData +" | ");
			}
			System.out.println();
		}
	}

}
