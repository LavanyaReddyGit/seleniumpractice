package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertsExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		// we can handle alerts by using explicit wait
		
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 
		WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(30));
		 
		 driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		 
	  Alert alert=	 myWait.until(ExpectedConditions.alertIsPresent());
		 
	
	  
	  alert.accept();
	  
	  Thread.sleep(3000);
	  
		 

	}

}
