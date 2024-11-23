package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 2) https://ui.vision/demo/webtest/frames/
		 *  1) switch to 5th frame 
		 *  2) click on link - opens new iframe
		 *   3) switch to inner frame 
		 *   4) check logo presence in the inner frame.
		 
		 */
		
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//switch to frame5
		
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		
		driver.switchTo().frame(frame5);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='https://a9t9.com']")).click();
		Thread.sleep(3000);
		
		 Boolean image=driver.findElement(By.xpath("//a[@id='logo']/child::img")).isDisplayed();
		 Thread.sleep(3000);
		 System.out.println("Image displayed:"+image);
		 
		 driver.quit();

	}

}
