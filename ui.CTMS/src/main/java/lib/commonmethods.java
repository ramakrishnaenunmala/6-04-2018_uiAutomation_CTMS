package lib;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonmethods 
{	
	WebDriver driver;
	Actions a;
	Alert a1;
	public  WebElement WebElementID(String identifier, String locator){
		WebElement e = null;
		switch (identifier) {
		case "id":
			e=driver.findElement(By.id(locator));
			break;
		case "name":
		e=driver.findElement(By.name(locator));
			break;
		case "xpath":
		e=driver.findElement(By.xpath(locator));
			break;
		case "linkText":
		e=driver.findElement(By.linkText(locator));
			break;

		default:
			System.out.println("locotar not found");
			e=null;
		}
		return e;
		
	
		
	}
	public void verifytitle(String title){
	if(driver.getTitle().equals("")){
		System.out.println("PASS");
	}
	else {
		System.out.println("FAIL");
	}
}
	public void sendKeys(String identifier, String locator, String content){
		WebElement sendkeys = WebElementID(identifier, locator);
		sendkeys.sendKeys(content);
	}
	public void cleartext(String identifier, String locator){
		WebElement cleartext = WebElementID(identifier, locator);
		cleartext.clear();
	}

	//click
	public void clickOnElement(String identifier,String locator){
	WebElement clickOnElement=WebElementID(identifier, locator);
	clickOnElement.click();
	}
	//waitforelement
	public void waitUntillElement(String path){
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}
	//verifyText

	public void verifyText(String identifier,String locator,String text ){
		
		WebElement verifyText=WebElementID(identifier, locator);
		if(verifyText.getText().equals(text)){
			System.out.println("text displayed");
		}
		else {
			System.out.println("Not displayed");
		}
		
	}
		//verify element present
		public void verifyElement(String identifier,String locator){
		WebElement verifyElement=WebElementID(identifier, locator);
		if(verifyElement.isDisplayed()){
			System.out.println("element is present");
		}
		else {
			System.out.println("element not present");
		}
		}
		
		//mouseover
		public void mouseOver(String identifier,String locator){
		a=new Actions(driver);
		WebElement mouseOver=WebElementID(identifier, locator);
		a.moveToElement(mouseOver).perform();
		}
		//DropDown
		public void dropDown(String identifier,String locator,String text ){
		WebElement dropDown=WebElementID(identifier, locator);
		Select select=new Select(dropDown);
		select.selectByVisibleText(text);
		}
		//getting data from table and verifying it with the required text  
		public void verifyElementInTable(String xpathlocator,String text)
		{
			boolean a=false;
			List<WebElement> tdlist = driver.findElements(By.xpath(xpathlocator));
			for(WebElement el: tdlist)  
			{
				if (el.getText().equals(text))
				{		
					a=true;	
					break;
				}
			}
			
			if(a==true)
			{
				System.out.println(text+" was identifed");				
			}
			else
			{
				System.out.println( text+" was not identifed");
			}
		}
		//alert
		public void alertbox(String text){
			 a1=driver.switchTo().alert();
			a1.accept();
			if(a.equals(text)){
			System.out.println("alert displayed");}
		else {
			System.out.println("Not");
				}
		}
		//threadsleep
		public void threadSleep() throws Exception{
			Thread.sleep(2000);
		}
		//quit
		public void tearDown(){
			driver.quit();
		}
		//close
		public void close(){
			driver.close();
		}
		//switch to frame
		public void switchToFrame(String identifier){
			driver.switchTo().frame(identifier);
		}
		//default frame
		public void defaultFrame(){
			driver.switchTo().defaultContent();
		}
}
