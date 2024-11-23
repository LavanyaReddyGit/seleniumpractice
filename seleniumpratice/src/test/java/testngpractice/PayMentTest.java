package testngpractice;

import org.testng.annotations.Test;

public class PayMentTest {

	
	@Test(priority=1,groups= {"regression","sanity","functional"})
	public void paymentInRuppes() {
		System.out.println("This is payment in rupees");
	}
	
	@Test(priority=2,groups= {"regression","sanity","functional"})
	public void paymentInDollers() {
		System.out.println("This is payment in dollers");
	}
	
}
