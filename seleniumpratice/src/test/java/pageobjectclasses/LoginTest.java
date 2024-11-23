package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeClass()
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void testLogin()
	{
		//Without using page factory
		//LoginPage1 lp=new LoginPage1(driver);
		
		// By using page factory
		LoginPage2 lp=new LoginPage2(driver);
		
		lp.setUserName("Admin");
		lp.setPwdName("admin123");
		lp.clickButton();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		System.out.println("Passed");
	}
	
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	

}
