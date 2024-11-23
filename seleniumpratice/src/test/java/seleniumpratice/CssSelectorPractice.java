package seleniumpratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorPractice {

	public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		 
		 //tag#id
		//  driver.findElement(By.cssSelector("input#username")).sendKeys("LasyaTest");
		  //without tag
		  //driver.findElement(By.cssSelector("#username")).sendKeys("LasyaTest");
		  //tag[attribute]
		  
		 //driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Reddy425");
		  //without tag
		  
		//driver.findElement(By.cssSelector("[type='password']")).sendKeys("Reddy425");
		  
		//tag.classname[attribute='value']
		
		 //driver.findElement(By.cssSelector("input.login_input[name='password']")).sendKeys("Reddy425");
		  //without tag
		  //driver.findElement(By.cssSelector(".login_input[name='password']")).sendKeys("Reddy425");
		
		//tag.classname
		//driver.findElement(By.cssSelector("td.login_register")).click();
		
		//without tag
		driver.findElement(By.cssSelector(".login_register")).click();
		  
		  
	}

}
