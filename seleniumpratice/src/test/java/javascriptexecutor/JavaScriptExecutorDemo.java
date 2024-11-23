package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//sendKeys() method
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John");
		
		
		WebElement input_Box=driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('value','john')", input_Box);
		
		
		//click() method
		
		//driver.findElement(By.xpath("//input[@id='female']")).click();
		
		
		WebElement female_Button=driver.findElement(By.xpath("//input[@id='female']"));
		
		//By using javascript method
		
		
		js.executeScript("arguments[0].click()", female_Button);
		
		
		

	}

}
