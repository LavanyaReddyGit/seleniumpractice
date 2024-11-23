package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		
		
		//Scroll down page by pixel number
		
		
		
		
		  JavascriptExecutor js=(JavascriptExecutor) driver;
			/*
			 * js.executeScript("window.scrollBy(0,1500)", "");
			 * System.out.println(js.executeScript("return window.pageYOffset;"));
			 */
		 
		
		
		//scroll  down the page bar   element is visible
		
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Back to top')]"));
		
		/*
		 * js.executeScript("arguments[0].scrollIntoView();", element);
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
		
		//scroll page till end of the page
		
		
		/*
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * System.out.println(js.executeScript("return window.pageYOffset;"));
		 */
		
		//Scroll up the page to inital stage
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		

	}

}
