package dropdown.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * 2) Hidden dropdown Login to OrangeHRM--> pim--> employee status
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Assignment3
		/*
		 * 3) https://testautomationpractice.blogspot.com/ colors multi select box
		 */
		
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		/*
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"
		 * ); Thread.sleep(2000);
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//span[text()='PIM']")).click();//click on pim
		 */		     
		     

	}

}
