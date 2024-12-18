package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo3 {
	
	public static void selectDate(WebDriver driver,String required_Month,String required_Year,String required_Date)
	{
      
		
		//select month
		WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select momthDropDown=new Select(month);
		momthDropDown.selectByVisibleText(required_Month);
		
		//select year
		
		WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearDropDown=new Select(year);
		yearDropDown.selectByVisibleText(required_Year);
		
		//select date
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(required_Date))
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
		
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		/*
		 * String required_Date="30"; String required_Month="Aug"; String
		 * required_Year="2016"; DatePickerDemo3.selectDate(driver, required_Month,
		 * required_Year, required_Date);
		 */
		DatePickerDemo3.selectDate(driver, "Nov","2016", "29");
	      Thread.sleep(3000);
	      driver.quit();
		
		
		
	}

}
