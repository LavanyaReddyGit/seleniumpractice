package dataproviderdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {
	
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dataProvider="dp")
	public void loginTest(String email,String pwd)
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		boolean status=driver.findElement(By.xpath("//div[@id='content']//h2[1]")).isDisplayed();
		if(status==true)
		{
			driver.findElement(By.xpath("(//a[text()='Logout'])[2]")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="dp",indices= {0,1,4})
	Object[][] loginData()
	{
	    Object data[][]= {
			{"abctesting123@gmail.com" ,"ABC@Testing"},
			{"dummydata@gmail.com"  ,"DummyData"},
			{"negativetesting@gmail.com" ,"NegativePwd"},
			{"abc123@gmail.com "  ,"ABC@123"},
			{"xyz123@gmail.com" ,"Xyz@123"},
				
			};
	
	return data;
	}
	
	

}
