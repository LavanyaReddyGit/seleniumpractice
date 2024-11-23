package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://ui.vision/demo/webtest/frames/");
	
		//switching to frame1
		/*
		 * WebElement
		 * frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		 * 
		 * driver.switchTo().frame(frame1);
		 * 
		 * driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome1");
		 * driver.quit();
		 */
	
		//Thread.sleep(3000);
		
		//Switching to frame2
		//currently driver switched to frame
		//we have to switch to the window then have to switch on frame2
		
		/*
		 * driver.switchTo().defaultContent();
		 * 
		 * WebElement
		 * frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		 * driver.switchTo().frame(frame2);
		 * driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome2")
		 * ; Thread.sleep(3000); driver.quit();
		 */
		
		//Frame3
		
		driver.switchTo().defaultContent();
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Welcome3");
		
		//Switch inner frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i8']/descendant::div[3]")).click();
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
