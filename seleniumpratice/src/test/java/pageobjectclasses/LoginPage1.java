package pageobjectclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {
	WebDriver driver;
	
	//constructor
	
	LoginPage1(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locators
	
	
	By txt_user_name=By.xpath("//input[@name='username']");
	By txt_pwd=By.xpath("//input[@name='password']");
	By bttn_login=By.xpath("//button[text()=' Login ']");
	// By allLinks=By.tagName("a"); (For finding multiple WebElements)
	
	
	//Action methods
	
	
	public void setUserName(String user)
	{
		driver.findElement(txt_user_name).sendKeys(user);
	}
	
	public void setPwdName(String pwd)
	{
		driver.findElement(txt_pwd).sendKeys(pwd);
	}
	
	
	
	public void clickButton()
	{
		driver.findElement(bttn_login).click();
	}
	
	

}
