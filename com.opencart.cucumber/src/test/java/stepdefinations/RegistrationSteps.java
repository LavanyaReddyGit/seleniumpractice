package stepdefinations;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageobjects.HomePage;
import pageobjects.MyAccountRegistrationPage;

public class RegistrationSteps {
    HomePage hp;
    MyAccountRegistrationPage regpage;
    WebDriver driver;
	
	@Given("the user navigates to register page")
	public void the_user_navigates_to_register_page() {
	    
		hp=new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	}

	@When("user enter the values into the below fields")
	public void user_enter_the_values_into_the_below_fields(DataTable dataTable) {
		regpage=new MyAccountRegistrationPage(BaseClass.getDriver());
		Map<String,String>  dataMap=dataTable.asMap(String.class, String.class);
		regpage.setFirstName(dataMap.get("firstname"));
		regpage.setLastName(dataMap.get("lastname"));
		regpage.setEmailId(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setTelephoneNum(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
		
	 
	}

	@When("click on the privacy policy")
	public void click_on_the_privacy_policy() {
	  
		regpage.checkPrivacyPolicy();
	}

	@When("clicks on continue button")
	public void clicks_on_continue_button() {
	   regpage.clikckContinueButton();
	}

	@Then("the usercshould see a your account registration message")
	public void the_usercshould_see_a_your_account_registration_message() {
	   
		String targetmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(targetmsg, "Your Account Has Been Created!");
	}



}
