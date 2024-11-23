package seleniumpratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XapthAxes {

	public static void main(String[] args) throws InterruptedException {
	
		/*
		 * self
		 *  parent 
		 *  child 
		 *  ancestor 
		 *  descendent
		 *  following
		 *  preceding
		 *  following-sibling
		 * preceding-sibling
		 */
		
		
		 WebDriver driver =new ChromeDriver();

		 driver.get("https://www.amazon.com/");
		 driver.manage().window().maximize();
		//Today's deals link
		 driver.findElement(By.xpath("//div[@id='nav-xshop']/child::a[1]")).click();
		 System.out.println(driver.getTitle());
		 System.out.println(driver.getCurrentUrl());
		//div[@id='nav-xshop']/child::a[1]

		//a[text()='Customer Service']/preceding-sibling::a


		//a[text()='Customer Service']//following-sibling::a[1]

		//div[@class='nav-fill']/descendant::inp
		 
		 //driver.quit();
	}

}
