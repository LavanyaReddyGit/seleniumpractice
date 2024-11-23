package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT  extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class)
	public void login_VerifyDDT(String username,String password,String res)
	{
		logger.info("******* TC003_LoginTestDDT started *******");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			logger.info("******* clicked on login link *******");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(username);
			lp.setPassword(password);
			lp.clickLoginButton();
			
			logger.info("******* provided credentials and clicked on login button *******");
			
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();
			
			if(res.equalsIgnoreCase("valid"))
			{
				if(targetpage==true)
				{
					macc.clickLogOut();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			
		    }
			
			if(res.equalsIgnoreCase("invalid"))
			{
				if(targetpage==true)
				{
					macc.clickLogOut();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
					
				}
			}
			Thread.sleep(3000);
			
		}
		catch(Exception e)
		{
			Assert.fail("An error occured"+ e.getMessage());
		}
		
		logger.info("******* TC003_LoginTestDDT started *******");
	}

}
