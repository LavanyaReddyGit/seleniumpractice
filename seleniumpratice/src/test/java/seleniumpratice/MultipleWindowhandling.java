package seleniumpratice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowhandling {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	//	String homeWindowID = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();

		// 1st approach
		// switch the windows by using windowID's
		//converting set into List Collection

		// 2nd Approach
		// By using for-each loop
		
		Set<String> windowIDs =driver.getWindowHandles();
		List<String> IDs=new ArrayList(windowIDs);
		
		String parentWindowID=IDs.get(0);
		String childWindowID=IDs.get(1);
		driver.switchTo().window(childWindowID);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys( "lavanyarishi62@gmail.com");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentWindowID);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		

		// Set<String> windowIDs = driver.getWindowHandles();

		/*
		 * for(String IDs:windowIDs) { String
		 * title=driver.switchTo().window(IDs).getTitle();
		 * if(title.equals("Human Resources Management Software | OrangeHRM")) { break;
		 * }
		 * 
		 * } driver.findElement(By.xpath("//input[@type='email']")).sendKeys(
		 * "lavanyarishi62@gmail.com"); System.out.println(driver.getTitle());
		 * Thread.sleep(3000);
		 * 
		 * driver.switchTo().window(homeWindowID);
		 * System.out.println(driver.getTitle()); driver.quit();
		 */

		// 3rd Approach
		// By using Iterator Concept

		/*
		 * Iterator<String> it = windowIDs.iterator();
		 * 
		 * while (it.hasNext()) {
		 * 
		 * driver.switchTo().window(it.next());
		 * if(driver.getTitle().equals("Human Resources Management Software | OrangeHRM"
		 * )) { break; }
		 * 
		 * } driver.findElement(By.xpath("//input[@type='email']")).sendKeys(
		 * "lavanyarishi62@gmail.com");
		 * 
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.switchTo().window(homeWindowID);
		 * 
		 * System.out.println(driver.getTitle());
		 * 
		 * driver.quit();
		 */

		// If we need to switch multiple browsers
		// We can create one reusable method
		
		//calling internal created method
		
		

	}

	

}
