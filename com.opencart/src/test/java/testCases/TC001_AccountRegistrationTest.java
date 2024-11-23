package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountRegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	
	@Test(groups= {"regression","master"},priority=1)
	public void verify_Account_RegistrationTest() throws InterruptedException
	{
		try {
			
	   logger.info("*********** Started  TC001_AccountRegistrationTest ****************");
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("Clicked on My Account Link");
		
		hp.clickRegister();
		
		logger.info("Clicked on Registration Link");
		
		MyAccountRegistrationPage regpage=new MyAccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		
		regpage.setFirstName(randomeAlphaNumeric().toUpperCase());
		
		regpage.setLastName(randomeAlphaNumeric().toUpperCase());
		
		regpage.setEmailId(randomeAlphaNumeric()+"@gmail.com");
		
		regpage.setTelephoneNum(randomeNumber());
		
		String password=randomeAlphaNumeric();
		
		regpage.setPassword(password);
		
		regpage.setConfirmPassword(password);
		
		regpage.checkPrivacyPolicy();
		
		
		regpage.clikckContinueButton();
		
		logger.info("Validating confirmation message");
		
		String cmsg=regpage.getConfirmationMsg();
		if(cmsg.equals("Your Account Has Been Created!"))
		{
			System.out.println("Test passed");
			 Assert.assertTrue(true);
	    }else
	    {
	    	logger.error("Test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
	    }
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
	

	


	}	

}
