package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountRegistrationPage extends BasePage{
	
	public MyAccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacypolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	
	//Actions
	
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	
	public void setEmailId(String email)
	{
		txtEmail.sendKeys(email);
	}
	

	
	public void setTelephoneNum(String tphone)
	{
		txtTelephone.sendKeys(tphone);
	}
	
	
	
	public void setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPwd.sendKeys(pwd);
	}
	
	
	public void checkPrivacyPolicy()
	{
		chkPrivacypolicy.click();
	}
	
	
	public void clikckContinueButton()
	{
		btnContinue.click();
		//sol2
		
		//btnContinue.submit();
		//javascript
		
		//actions class
		
		//webdriverwait
	}
	
	
	
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirm.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	
	

}
