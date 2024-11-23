package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BuyTicket {
	//UDF for selecting futuredate
	public static void selectFutureDate(WebDriver driver,String year,String month,String date)
	{
		   //select year
		   
		   
		   while(true)
		   {
		    String  dispalyed_Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		 
			  if(dispalyed_Year.equals(year))
			  {
				  break;
			  }
			 
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		  }
		   
		   //select month
			  
			   WebElement monthDropDown=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			   Select mp=new Select(monthDropDown);
			   mp.selectByVisibleText("Nov");
			   
			   //select date
			   
			   
			   
			   List<WebElement> allDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
			   
			   for(WebElement dt:allDates)
			   {
				   if(dt.getText().equals(date))
				   {
					   dt.click();
					   break;
				   }
			   }
	}
	//UDF for selecting previous date
	public static void selectPreviousDate(WebDriver driver,String year,String month,String date)
	{
		   //select year
		   
		   
		   while(true)
		   {
		    String  dispalyed_Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		 
			  if(dispalyed_Year.equals(year))
			  {
				  break;
			  }
			 
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		  }
		   
		   //select month
			  
			   WebElement mdDown=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			   Select mp=new Select(mdDown);
			   mp.selectByVisibleText("Dec");
			   
			   //select date
			   
			   
			   
			   List<WebElement> allDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
			   
			   for(WebElement dt:allDates)
			   {
				   if(dt.getText().equals(date))
				   {
					   dt.click();
					   break;
				   }
			   }
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dummy-tickets.com/buyticket");
		
		driver.findElement(By.xpath("//a[text()='Both']")).click();
		
		driver.findElement(By.xpath("//input[@value='roundtripfh']")).click();
		
		//from
		driver.findElement(By.xpath("(//input[@name='source[]'])[5]")).sendKeys("Rajiv");
		Thread.sleep(3000);
		List<WebElement> from=driver.findElements(By.xpath("//div[@class='suggestion-block']//p"));
		for(WebElement fm:from)
		{
			if(fm.getText().contains("Rajiv Gandhi International Airport"))
			{
				fm.click();
				break;
			}
		}
		
		//To
		
		  driver.findElement(By.xpath("(//input[@name='destination[]'])[5]")).sendKeys("Bangalore");
		  Thread.sleep(3000);
		  List<WebElement> to=driver.findElements(By.xpath("//div[@class='suggestion-block']//p")); 
		  for(WebElement t:to) 
		  {
		     if(t.getText().contains("HAL Bangalore")) 
		      {
		         t.click();
		         break;
		      }
		  }
		  
		   String year="2025";
			String month="Jun";
			String date="12";
			
			
		  
		  
		  //open departure datepicker
		  driver.findElement(By.xpath("(//input[@name='departure[]'])[5]")).click();
		  Thread.sleep(3000);
		  BuyTicket.selectFutureDate(driver, year, month, date);
		  
		  //open return datepicker
		  Thread.sleep(2000);		   
		   driver.findElement(By.xpath("(//input[@placeholder='Return Date'])[2]")).click();
		   Thread.sleep(3000);
		   BuyTicket.selectPreviousDate(driver, "2020", "12", "20");
		   
		   Thread.sleep(3000);
		   driver.quit();
		   
			 
			
	
	}

	}


