package seleniumpratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathExample {

	public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver();

		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		 
		// driver.findElement(By.xpath("//input[@name='search']")).sendKeys("T-shirts");
		 
		// driver.findElement(By.xpath("//input[contains(@name,'sea')]")).sendKeys("T-shirts");
		 
		driver.findElement(By.xpath("//input[starts-with(@name,'sea')]")).sendKeys("T-shirts");
		 
		 //chained xpath
		 
	//	driver.findElement(By.xpath("//div[@class='col-md-5']/div/input")).sendKeys("T-shirts");
		
		
		// xpath for innertext
		
		//input[text()='text']
		
       //input[contains(text(),'text')]
		 
	}

}
