package testngpractice;

import org.testng.annotations.Test;

public class LoginTest {
	
	
	/*
	 * loginbyemail -- sanity
	 *  loginbyfacebook --sanity
	 *   loginbytwitter  --sanity
	 *   
	 *   signup by email --regression
	 *   signup by facebook -- regression
	 *   signup by twitter --regression
	 *   
	 *   payment in rupees --sanity,regression (functional)
	 *   payment in dollers --sanity,regression (functional)
	 *   
	 */
	

	
	@Test(priority=1,groups= {"sanity"})
	public void loginByEmail() {
		System.out.println("This is login by email");
	}
	
	@Test(priority=2,groups= {"sanity"})
	public void loginByFaceBook() {
		System.out.println("This is login by facebook");
	}
	
	@Test(priority=3,groups= {"sanity"})
	public void loginByTwitter() {
		System.out.println("This is login by twitter");
	}
}
