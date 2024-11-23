package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
	public WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException
	{
		
		//1. Launch browser
		driver=new ChromeDriver();
		
		
		//2. Navigate to url 'http://automationexercise.com'
		driver.get("https://automationexercise.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void verify_Register() throws InterruptedException
	{
		//3. Verify that home page is visible successfully
		boolean homePage=driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed();
		Assert.assertEquals(homePage, true);
		Thread.sleep(2000);
		
		//4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		Thread.sleep(2000);
		
		//5. Verify 'New User Signup!' is visible
		boolean signup=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		Thread.sleep(2000);
		
		Assert.assertEquals(signup, true);	
		Thread.sleep(2000);
		//6. Enter name and email address
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test425");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("test426@gmail.com");
		Thread.sleep(2000);
		
		
		//7. Click 'Signup' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		Thread.sleep(2000);
		
		//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		
		boolean msg=driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
		
		Assert.assertEquals(msg, true);
		Thread.sleep(2000);
		
		//9. Fill details: Title, Name, Email, Password, Date of birth
		
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		Thread.sleep(2000);
		
		
		WebElement txtPwd=driver.findElement(By.xpath("//input[@id='password']"));
		txtPwd.sendKeys("Practice@425");
		Thread.sleep(2000);
		
		
		//DOB
		
		Select s1=new Select(driver.findElement(By.xpath("//select[@id='days']")));
		s1.selectByVisibleText("6");
		Thread.sleep(2000);
		
		Select s2=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		s2.selectByVisibleText("April");
		Thread.sleep(2000);
		
		Select s3=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		s3.selectByVisibleText("2000");
		
		
		//10. Select checkbox 'Sign up for our newsletter!'
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		//11. Select checkbox 'Receive special offers from our partners!'
		
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		Thread.sleep(2000);
		
		//12. Fill details: First name, Last name, Company, Address, Address2,
		//Country, State, City, Zipcode, Mobile Number
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Test425");
		
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("425");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("L&T");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Rayadurgam village");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("CKpalli mandal");
		
		Select countryDropDown=new Select(driver.findElement(By.xpath("//select[@id='country']")));
		countryDropDown.selectByVisibleText("India");
		
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("AndhraPradesh");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Anantapur");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("515213");
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9087654321");
		
		Thread.sleep(3000);
		
		
	//	13. Click 'Create Account button'
		
		
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		Thread.sleep(2000);
		
		
		
		
		//14. Verify that 'ACCOUNT CREATED!' is visible
		boolean acreated=driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
		Assert.assertEquals(acreated, true);
		
		Thread.sleep(2000);
		
		//15. Click 'Continue' button
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		
		
		//16. Verify that 'Logged in as username' is visible
		
		
		String userName=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[10]")).getText();
		
		Assert.assertEquals(userName, "Logged in as Test425");
		
		Thread.sleep(2000);
		
		//17. Click 'Delete Account' button
		
		driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
		
		Thread.sleep(2000);
		
		
		//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		
		
		boolean deletemsg=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		
		Assert.assertEquals(deletemsg, true);
		Thread.sleep(2000);
		
		System.out.println("Test case passed successfully");
		
			
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
