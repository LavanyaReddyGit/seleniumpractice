package mousehovering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement seoul=driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement southKorea=driver.findElement(By.xpath("//div[@id='box105']"));
		
		//DragAndDrop
		
		
		  Actions act=new Actions(driver);
		  act.dragAndDrop(seoul, southKorea)
		  .perform();
		  
		  Thread.sleep(5000);
		 
		
		//reverse  dropdown
		WebElement source=driver.findElement(By.xpath("//div[@id='box5']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='dropContent']"));
		act.dragAndDrop(source, target)
		.perform();
		
		Thread.sleep(3000);
		
		
		driver.quit();
		 
			 
			 
	}

}
