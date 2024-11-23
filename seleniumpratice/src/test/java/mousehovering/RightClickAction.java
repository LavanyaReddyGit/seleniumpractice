package mousehovering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		// To right click on element we use contextClick() method
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));
		
		Actions act=new Actions(driver);
		//right click action
		act.contextClick(button)
		.build()
		.perform();
		
		//click on copy
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		Thread.sleep(3000);
		// close alert
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.quit();

	}

}
