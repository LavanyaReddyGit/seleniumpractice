package testngpractice;

import org.testng.annotations.Test;

public class SignUpTest {

	
	@Test(priority=1,groups= {"regression"})
	public void signUpByEmail() {
		System.out.println("This is sign up by email");
	}
	
	@Test(priority=2,groups= {"regression"})
	public void signUpByFaceBook() {
		System.out.println("This is sign up facebook");
	}
	
	@Test(priority=3,groups= {"regression"})
	public void signUpByTwitter() {
		System.out.println("This is sign up twitter");
	}
}
