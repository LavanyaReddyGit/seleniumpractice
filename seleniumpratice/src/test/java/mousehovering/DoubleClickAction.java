package mousehovering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		//switch to the frame
		
		driver.switchTo().frame("iframeResult");
		
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2=driver.findElement(By.xpath("//input[@id='field1']"));
		//Clear field1 value
		field1.clear();
		//Pass new value
		field1.sendKeys("WELCOME");
		
		//double click on button to copy the data of field1
		WebElement copyButton=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions act=new Actions(driver);
		act.doubleClick(copyButton)
		.build()
		.perform();
		
		String field1Text=field1.getAttribute("value");
		String field2Text=field2.getAttribute("value");
		
		//validation
		
		if(field1Text.equals(field2Text))
		{
			System.out.println("Text copied");
		}
		else
		{
			System.out.println("Text not copied properly");
		}
		

	}

}
