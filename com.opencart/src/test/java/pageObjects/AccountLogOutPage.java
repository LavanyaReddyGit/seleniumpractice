package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogOutPage extends BasePage {
	
	public AccountLogOutPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement msgLogOut;
	
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="(//a[text()='Login'])[1]")
	WebElement lnkLogin;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement btnContinue;
	
	
	public  String conMsg()
	{
		try
		{
			 return msgLogOut.getText();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public void myAccount()
	{
		lnkMyAccount.click();
	}
	
	public boolean loginLink()
	{
		try
		{
			
			return lnkLogin.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}
		
		
		
		
	}
	
	
	

	public void continueButton() {
		btnContinue.click();
		
	}
	
	
	
	
	
	
	
	
	
	

}
