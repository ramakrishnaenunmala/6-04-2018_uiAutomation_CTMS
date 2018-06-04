package com.ui.Automation.testHomepage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.Automation.testBase.BaseClass;
import com.ui.Automation.uiActions.Homepage;

public class TC_001VerifyLoginCredentiols extends BaseClass


{
	Homepage home;
	@BeforeTest
	public void setUp()
	{
		Int();
		
	}
		
	@Test
	public void VerifyLoginCredentiols()throws IOException
	{
		home=new Homepage(driver);
		
		home.loginTovalidApp();
	

	              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           //The below method will save the screen shot in d drive with name "screenshot.png"
	              FileUtils.copyFile(scrFile, new File("MyfirstScreen78.png"));
	   }
	
	@AfterTest
	public void endTest(){
		driver.quit();
	}
}
