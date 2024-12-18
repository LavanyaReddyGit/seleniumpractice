package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//h2[text()='My Account']")
    WebElement msgHeading;
	
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	WebElement btnLogout;
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	
	@FindBy(xpath="(//a[text()='Logout'])[1]")
    WebElement lnkLogOut;
	
	public boolean isMyAccountPageExists()
	{
		try {
		    return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	
	public void clickLogOut()
	{
		btnLogout.click();
	}
	
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	
	public void lnkLogOut()
	{
		lnkLogOut.click();
	}
	
	
}
