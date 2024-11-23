package keyboardevents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkInNewPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.nopcommerce.com/");
		
		//Open the registration link in new page
		
		WebElement registration_Link=driver.findElement(By.xpath("//a[text()='Register']"));
		
	Actions act=new Actions(driver);
	//Control+click() is the short cut to open the link in new page
	
	act.keyDown(Keys.CONTROL).click(registration_Link).keyUp(Keys.CONTROL).perform();
	
	//switching to registration page
	
	List<String> ids=new ArrayList (driver.getWindowHandles());
	
	driver.switchTo().window(ids.get(1));
	
	//To switch to home page
	
	driver.switchTo().window(ids.get(0));
	
	Thread.sleep(3000);
	
	driver.quit();
	}

}
