package testngpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTesting {
  WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp(String br,String url) throws InterruptedException
	{
		switch(br.toLowerCase())
		{
			case "chrome" :  driver=new ChromeDriver();break;
			case "edge"   :  driver=new EdgeDriver();break;
			case "firefox":  driver=new FirefoxDriver();break;
			default :System.out.println("invalid browser");return;
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Thread.sleep(3000);
	}
	
	
	


	@Test(priority=1)
	public void logoTest() 
	{
		
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	public void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=3)
	public void testCurrentURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
