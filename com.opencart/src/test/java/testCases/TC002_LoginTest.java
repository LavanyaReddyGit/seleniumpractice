package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	
	
	@Test(groups= {"sanity","master"},priority=2)
	public void verify_LoginTest() {
		logger.info("****** TC002_LoginTest started ******");
		logger.debug("capturing application debug logs");
		
		try {
			//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link on the homepage");
		hp.clickLogin();
		logger.info("Clicked on login link on the homepage");
		//LoginPage
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Provided valod  credentials to login");
		
		lp.setEmail(pr.getProperty("username"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLoginButton();
		logger.info("Clicked on loginbutton");
		
		//MyAccount Page
		
		MyAccountPage macc=new MyAccountPage(driver);
		logger.info("My Account page exists");
		
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true);
     
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		finally {
			logger.info("****** TC002_LoginTest finished ******");
		}
		
	}

}
