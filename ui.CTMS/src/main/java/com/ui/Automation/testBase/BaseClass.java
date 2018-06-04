package com.ui.Automation.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass 
{

	
	
	public WebDriver driver;
	String Brow="chrome";
	String url="http://apps.qaplanet.in/qahrm/login.php";

	
	public void seloectBrow(String brow)
	{
		if(brow.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver=new ChromeDriver();}
		else if (brow.equalsIgnoreCase("firfox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/gecko.exe");
			driver=new FirefoxDriver();}
		
	}
	public void geturl(String url){
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void Int(){
		seloectBrow(Brow);
		geturl(url);
	}
}

