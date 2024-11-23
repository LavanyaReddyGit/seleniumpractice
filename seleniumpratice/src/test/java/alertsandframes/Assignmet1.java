package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmet1 {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://mypage.rediff.com/login/dologin");
		 
		 //click on login button without providing anything 
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 Thread.sleep(3000);
		 
		 driver.switchTo().alert().accept();
		 Thread.sleep(3000);
		 
		 driver.quit();

	}

}
