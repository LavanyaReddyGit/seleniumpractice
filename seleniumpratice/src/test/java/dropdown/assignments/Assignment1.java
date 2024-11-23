package dropdown.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1) Handle country dropdown with/without using
		 *  Select class:https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/(link is not working)
		  
		 * a) count total number of options
		 *  b) print all the options 
		 *  c) select one  option
		
		 */
		//With using select class
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.flipkart.com/");
		//a) count total number of options
		
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//img[@alt='Chevron']"))).pause(3).perform();

		Thread.sleep(3000);
		
		WebElement dropDown=driver.findElement(By.xpath("//ul[contains(@class,'_3YjYK7 ecs1XG')]"));
		Thread.sleep(3000);
		List<WebElement>  dropList=dropDown.findElements(By.xpath("//ul//a[@class='yx2hEq']//li//div"));
		Thread.sleep(3000);
		
		System.out.println("Total no.of options:"+dropList.size());
		Thread.sleep(3000);
		for(int i=0;i<dropList.size();i++)
		{
			System.out.println("All Options:"+dropList.get(i).getText());
		}
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		

	}

}
