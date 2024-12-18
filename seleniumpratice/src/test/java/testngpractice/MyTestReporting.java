package testngpractice;

import java.time.Duration;

//@Listeners(testngpractice.ExtentReportManager.class);

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
@Listeners(testngpractice.ExtentReportManager.class)
public class MyTestReporting {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
				
	}
	@Test(priority=1)
	public void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	    Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	public void testAppUrl() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/log");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"testAppUrl"})
	public void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
