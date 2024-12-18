package seleniumpratice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowhandling2 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		String homeWindowID = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();

		// calling internal created method

		MultipleWindowhandling2.swtichWindow("Human Resources Management Software | OrangeHRM");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("lavanyarishi62@gmail.com");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		driver.switchTo().window(homeWindowID);
		Thread.sleep(3000);

		System.out.println(driver.getTitle());

		driver.quit();

	}

	public static void swtichWindow(String expTitle) {

		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> it = windowIDs.iterator();
		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			if (driver.getTitle().equals(expTitle)) {
				break;

			}

		}

	}

}
