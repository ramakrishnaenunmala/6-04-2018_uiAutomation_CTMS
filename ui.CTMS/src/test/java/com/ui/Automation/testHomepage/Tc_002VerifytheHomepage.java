package com.ui.Automation.testHomepage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.Automation.testBase.BaseClass;
import com.ui.Automation.uiActions.Homepage;

public class Tc_002VerifytheHomepage extends BaseClass
{
	Homepage home;
	@BeforeTest
	public void setUP(){
		Int();
		
	}
	@Test
	public void VerifytheHomepage(){
		home=new Homepage(driver);
		home.loginTovalidApp();

		
		driver.findElement(By.xpath("//*[@id='admin']/a/span")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='pim']/a/span")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='leave']/a/span")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='time']/a/span")).isDisplayed();
		driver.findElement(By.xpath("//*[@id='help']/a/span")).isDisplayed();
	}
	
	@AfterTest
	public void endTest(){
		driver.close();
	}
}
