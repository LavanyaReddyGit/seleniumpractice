package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {
	
	public static void selectFutureDate(WebDriver driver,String month,String year,String date)
	{
      //select month&year
		while(true)
		{
			String current_Month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String current_Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(current_Month.equals(month)&&current_Year.equals(year))
			{
				break;
			}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

	    }
		
		//select date
		
		List<WebElement> allData=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		for(WebElement dt:allData)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	public static void selectPreviousDate(WebDriver driver,String month,String year,String date)
	{
      //select month&year
		while(true)
		{
			String current_Month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String current_Year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(current_Month.equals(month)&&current_Year.equals(year))
			{
				break;
			}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

	    }
		
		//select date
		
		List<WebElement> allData=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		for(WebElement dt:allData)
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
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String month="December";
		String year="2020";
		String date="15";
		
		//DatePickerDemo2.selectFutureDate(driver, month, year, date);
		DatePickerDemo2.selectPreviousDate(driver, month, year, date);
		Thread.sleep(3000);
		
		driver.quit();
		
		
		//select date

 }
}
