package pageobjectclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	WebDriver driver;
	
	//constructor
	
	LoginPage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locators
    // Using Page factory
	
	//Approach1
	
	/*
	 * @FindBy(xpath="//input[@name='username']") WebElement txt_user_name;
	 */
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_pwd_name;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement login_button;
	
	
	//Approache2
	@FindBy(how=How.XPATH , using="//input[@name='username']")
	WebElement txt_user_name;;
	//For multiple elements
	
	//@FindBy(tagName="a")
	// List<WebElement> elements;
	
	
	//Action methods
	
	
	public void setUserName(String user)
	{
		txt_user_name.sendKeys(user);
	}
	
	public void setPwdName(String pwd)
	{
		txt_pwd_name.sendKeys(pwd);
	}
	
	public void clickButton()
	{
		login_button.click();
	}
	
	

}
