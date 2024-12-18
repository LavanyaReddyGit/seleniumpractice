package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
  

public class TC003_LogOutTest extends BaseClass {
	
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	LogoutPage logoutPage;
	AccountLogOutPage accLogout;
	@Test
	public void logOutTest() throws InterruptedException
	{
		
		//Home Page
		
		 hp=new HomePage(driver);
		 
		 hp.clickMyAccount();
		 
		 hp.clickLogin();
		
		 
		 System.out.println("clicked on login");
		 //Login page
		 
		lp= new LoginPage(driver);
		
		lp.setEmail(pr.getProperty("username"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLoginButton();
		
		 macc=new MyAccountPage(driver);
		 
		 macc.clickLogOut();
		 Thread.sleep(3000);
		 System.out.println("Clicked on logout");
		 
		 //AccountLogOut Page
		 
		  accLogout=new AccountLogOutPage(driver);
		 String confirmationMsg= accLogout.conMsg();
		 Assert.assertEquals(confirmationMsg, "Account Logout");
		 
		 System.out.println("Got confirmation message");
		 
		 accLogout.myAccount();
		 
		boolean loginLink= accLogout.loginLink();
		
		Assert.assertEquals(loginLink, true);
		Thread.sleep(3000);
		
		System.out.println("Login link presented");
		
		
		accLogout.continueButton();
		
	    System.out.println("clicked on continue button");
	    
	     System.out.println("naviages to homepage");
	     Thread.sleep(3000);
	     
	  
		 
		
		 
		 
		 
		 
		
		
		
		
	}
	
 

}
