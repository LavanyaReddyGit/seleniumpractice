package testngpractice;

import org.testng.Assert;
import org.testng.annotations.*;

public class DependencyOnMethodDemo1 {
	
	@Test(priority=1)
	public void openAPP()
	{
		System.out.println("Open the application");
		Assert.assertTrue(false);
	}
	@Test(priority=2,dependsOnMethods= {"openAPP"})
	public void loginTest()
	{
		System.out.println("login to the application");
		Assert.assertTrue(true);
	}
	@Test(priority=3)
	public void searchTest()
	{
		System.out.println("Search in the application");
		Assert.assertTrue(true);
	}
	@Test(priority=4,dependsOnMethods= {"searchTest","loginTest"})
	public void advsearchTest()
	{
		System.out.println("AdvancedSearch in the application");
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	public void logOutTest()
	{
		System.out.println("logOut From the  application");
		Assert.assertTrue(true);
	}
	
	

}
