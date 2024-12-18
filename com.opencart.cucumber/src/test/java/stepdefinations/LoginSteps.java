package stepdefinations;

import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.*;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utility.DataReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

public class LoginSteps {
    WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;
	
	List<HashMap<String,String>> dataMap;
	@Given("user navigates to the login page")
	public void navigateToLoginPage() {
		
		
	    BaseClass.getLogger().info("Go to MyAccount-->click on login link");
		hp=new HomePage(BaseClass.getDriver());	
		hp.clickMyAccount();
		hp.clickLogin();
		
	}

	@When("user enters email as {string} and password as {string}")
	public void enterValidCredentials(String email, String password) {
		BaseClass.getLogger().info("Enter valid credentials");
		lp=new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
	}

	@When("the user clicks on the Login button")
	public void clickLoginBtn() {
	    
		BaseClass.getLogger().info("Click on login button");
		
		lp.clickLoginButton();
	}

	@Then("the user should be redirected to the MyAccount Page")
	public void redirectToAccountPage() throws InterruptedException {
		
		BaseClass.getLogger().info("Verify MyAccount page exists or not");
	   
	   macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
   }
	
	
	//Data Driven excel
	
	@When("user should be redirected to the My AccountPage by passing email and password with  excel row {string}>")
	public void user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) throws IOException {
		
		dataMap=DataReader.data(System.getProperty("user.dir")+"\\testdata\\Opencart_LoginDataDDT.xlsx", "Sheet1");
		
		int index=Integer.parseInt(rows)-1;
		
	String email=dataMap.get(index).get("username");
	String pwd=dataMap.get(index).get("password");
	String exp_result=dataMap.get(index).get("res");
	
	lp=new LoginPage(BaseClass.getDriver());
	
	lp.setEmail(email);
	lp.setPassword(pwd);
	
	lp.clickLoginButton();
	
	macc=new MyAccountPage(BaseClass.getDriver());
	
	
	
	try
	{
		boolean targetPage=macc.isMyAccountPageExists();
		System.out.println("target page: "+ targetPage);
		if(exp_result=="valid")
		{
			if(targetPage==true)
			{
				macc.clickLogOut();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if (exp_result=="invalid")
		{
			if(targetPage==true)
			{
				macc.clickLogOut();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
		
		
		
	    
	}

	

}
