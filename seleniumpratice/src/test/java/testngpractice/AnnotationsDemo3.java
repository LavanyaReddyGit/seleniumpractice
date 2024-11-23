package testngpractice;

import org.testng.annotations.*;

public class AnnotationsDemo3 {
	
	/*
	 * login--repeating 
	 * searc 
	 *  advancedsearch
	 *  logout
	 */
	
	//In this test case our requirement is have to login once 
	//and logout after all test methods then use @BeforeClass & @AfterClass annotations
	
	
	@BeforeClass
	public void loginTest()
	{
		System.out.println("login to the application");
	}
	
	@AfterClass
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
