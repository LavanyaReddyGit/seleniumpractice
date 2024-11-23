package seleniumpratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitsConcept {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
		/*
		 * implicit wait 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 */       
       //Thread.sleep(5000);//hard wait
       //explicitwait
       //Declaration
        
		
		//  WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(30));
		  
		 // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// usage
		/*
		 * WebElement
		 * userInputBox=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//input[@placeholder='Username']"))); userInputBox.sendKeys("Admin");
		 */
		 
       // driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
       
       //Fluentwait
       //declaration
        
         FluentWait<WebDriver> myWait=new FluentWait<WebDriver>(driver)
        		 .withTimeout(Duration.ofSeconds(30))
        		 .pollingEvery(Duration.ofSeconds(2))
        		 .ignoring(NoSuchElementException.class);
         
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
         
         //usage
         myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");
      /* WebElement txtUserName=myWait.until( new Function<WebDriver,WebElement>()
    		   {
    	         public WebElement apply(WebDriver driver)
    	         {
    	        	 WebElement txtUserName=driver.findElements(By.xpath("//input[@placeholder='Username']"));
    	        	 return txtUserName;
    	         }
    		   }

	   
       txtUserName.sendKeys("Admin");
       //driver.quit();
	}*/

	}
}
