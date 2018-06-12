package com.ui.Automation.uiActions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Homepage {

WebDriver driver;
	
@FindBy(xpath="//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input")
WebElement username;
	
@FindBy(xpath="//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")
WebElement password;

@FindBy(xpath="//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input")
WebElement clear;

@FindBy(xpath="//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input")
WebElement Login;




public Homepage(WebDriver driver){
	PageFactory.initElements(driver, this);
}

public void loginTovalidApp(){
	  File file = new File("D:\\workspace\\Ramki\\ui.CTMS\\src\\main\\java\\com\\ui\\Automation\\config\\brow.properties");
	  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	//driver.get(prop.getProperty("URL"));
	username.clear();
	username.sendKeys(prop.getProperty("usernamevalue"));
	Reporter.log("Enter username"+username+" and obect is"+username.toString());
	
	password.clear();
	password.sendKeys(prop.getProperty("passwoardvalue"));
	Reporter.log("Enter passwoard"+password+" and obect is"+password.toString());
	
	Login.click();
	Reporter.log("clicked on Login and object is"+Login.toString());
	
	clear.isDisplayed();
	Reporter.log("clear element is present"+ clear+"and object is"+clear.toString());
	
}

}


