package dropdown;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='country']"));

		// convention way
		// by using sendkeys method

		
		/*
		 * countryDropDown.sendKeys("India");
		 * 
		 * Thread.sleep(3000); driver.quit();
		 */
		 

		// By using select class

		Select s1 = new Select(countryDropDown);
		/*
		 * s1.selectByIndex(9);
		 * 
		 * s1.selectByValue("india"); s1.selectByVisibleText("India");
		 * Thread.sleep(3000); driver.quit();
		 */

		// to get all the options

		List<WebElement> clist=s1.getOptions();
		/*
		 * System.out.println(clist.size()); for(int i=0;i<clist.size();i++) {
		 * System.out.println(clist.get(i).getText());
		 * 
		 * }
		 */
		//for-each loop
		
		
		  for(WebElement op:clist)
		  { 
			  System.out.println(op.getText());
			  
		  }
		 
		//using iterator
		
		
		  Iterator<WebElement> it=clist.iterator();
		  while(it.hasNext())
		  {
		  System.out.println(it.next().getText());
		  }
		 
			
	}

}
