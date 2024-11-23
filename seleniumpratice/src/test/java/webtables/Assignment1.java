package webtables;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		//launch browser
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://www.blazedemo.com/");
		 
		 
		 
		 //select departure city
		 
		 Thread.sleep(2000);
		 
		Select depcity= new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		depcity.selectByVisibleText("Portland");
		Thread.sleep(2000);
		
		//select destination city
		
		Select descity= new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		descity.selectByVisibleText("New York");
		Thread.sleep(2000);
		
		
		//click on find flights button
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//total no.of rows
		
		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println(rows); //5
		//total no.of cols
		
		int cols=driver.findElements(By.xpath("//table[@class='table']//thead//th")).size();
		System.out.println(cols); //6
		
		//capture prices then store in array
		String pricesArray[]=new String[rows];
		
		  for(int r=1;r<=rows;r++)
		  { 
		 
		   String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
		   pricesArray[r-1]=price;
		  
		  }
		  for(String arrvalue:pricesArray)
		  {
			  System.out.println(arrvalue);
		  }
		  
		  Arrays.sort(pricesArray);
		  String lowestPrice=pricesArray[0];
		  System.out.println(lowestPrice);
		  
		  
		  //find the flight based on lowestprice
		  
		  for(int r=1;r<=rows;r++)
		  {
			  String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			  if(price.equals(lowestPrice))
			  {
				  driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]//input")).click();
				  break;
			  }
		  }
		  Thread.sleep(2000);
		  
		  //fill all details
		  
		  driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Lavanya");
		  driver.findElement(By.xpath("//input[@id='address']")).sendKeys("456-main street");
		  driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Anantapur");
		 // driver.findElement(By.xpath("//input[text()='state']")).sendKeys("AndhraPradesh");
		  driver.findElement(By.xpath("//input[text()='zipcode']")).sendKeys("456-main street");
		  
		  Select cardType=new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		  cardType.selectByVisibleText("American Express");
		  driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("4");
		  driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2000");
		  driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Digavallu Lavanya Reddy");
		  driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		  
		  String confirmMessage= driver.findElement(By.xpath("//div//h1")).getText();
		  Thread.sleep(3000);
		  
		  if(confirmMessage.equals("Thank you for your purchase today!"))
		  {
			  System.out.println("test case passed");
		  }
		  else
		  {
			  System.out.println("test case failed");
		  }
		  
		  Thread.sleep(5000);
		driver.quit();
		
		
		
		

	}

}
