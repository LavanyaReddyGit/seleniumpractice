package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException {
    
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Simple alert
		
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click()
		 * ;
		 * 
		 * driver.switchTo().alert().accept();
		 * 
		 * Thread.sleep(3000);
		 */
		//Confirmation alert
		
		
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
		 * (); Thread.sleep(3000);
		 * 
		 * Alert alert=driver.switchTo().alert(); alert.dismiss(); Thread.sleep(3000);
		 */
		
	    //Prompt Alert
		
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		 Thread.sleep(3000);
		 Alert alert=driver.switchTo().alert();
			/*
			 * String expText= alert.getText(); if
			 * (expText.equalsIgnoreCase("I am a JS prompt")) {
			 * System.out.println("test case passed"); } else {
			 * System.out.println("test case failed");
			 * 
			 * }
			 */
		 
		 alert.sendKeys("Welcome");
		 alert.accept();
		 
		String res= driver.findElement(By.xpath("//p[text()='You entered: Welcome']")).getText();
		if(res.contains("Welcome"))
		{
			System.out.println(" test case passed");
		}
		else
		{
			System.out.println("test case failed");
		}
		 
		 
		 Thread.sleep(5000);
		 
		
		
		
		
		
		
		//driver.quit();
		
 

	}

}
