package testngpractice;

import org.testng.annotations.*;

public class AnnotationsDemo2 {
	
	/*
	 * login--repeating 
	 * serach
	 *  logout 
	 *  login--repeating 
	 *  advancedsearch
	 */
	
	//For repeatting testcases we use @BeforeMethod &AfterMethod Annotations
	
	
	@BeforeMethod
	public void loginTest()
	{
		System.out.println("login to the application");
	}
	
	@AfterMethod
	public void logoutTest()
	{
		System.out.println("logout from the application");
	}
	
	@Test(priority=1)
	public void searchtest()
	{
		System.out.println("Search for a product");
	}
	
	@Test(priority=2)
	public void advancedSearchTest()
	{
		System.out.println("Advanced search for a product");
	}

}
