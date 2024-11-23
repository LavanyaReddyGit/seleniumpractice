package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker1 {

	public static void selectFutureDate(WebDriver driver, String year,String month,  String date) {
		while (true) {
			String current_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			String current_Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (current_Year.equals(year) && current_Month.equals(month)) {
				break;

			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // future year
			// driver.findElement(By.xpath("//span[@class='ui-icon
			// ui-icon-circle-triangle-w']")).click();//previous year
		}

		// selecting day

		List<WebElement> all_Dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : all_Dates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	// selecting past dates
	public static void selectPreviousDate(WebDriver driver,  String year,String month, String date) {
		// selecting month& year
		while (true) {
			String current_Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			String current_Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (current_Month.equals(month) && current_Year.equals(year)) {
				break;

			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();// previous year
		}

		// selecting day

		List<WebElement> all_Dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : all_Dates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/datepicker/");
		Thread.sleep(1000);

		driver.switchTo().frame(0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		// by using sendKeys Method
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/04/2025");

		// By using date picker
		// first we need to capture the month and year then focus on date
		// selecting month&year
		//previous
		  /*String year="2020"; 
		  String month="November";
		  String date="20";*/
		  //future
		  String year="2026"; 
		  String month="November";
		  String date="20";
		 
		/*
		 * driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		 * selectFutureDate(driver, "November", "2026", "20");
		 */

		//DatePicker1.selectPreviousDate(driver, year,month,  date);
		//DatePicker1.selectPreviousDate(driver,"2020","November","20");
		  
		  DatePicker1.selectFutureDate(driver, year, month, date);
		
		  
		  
		 

		Thread.sleep(3000);
		driver.quit();

	}

}
