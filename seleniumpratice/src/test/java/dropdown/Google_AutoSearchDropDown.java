package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_AutoSearchDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");

		Thread.sleep(3000);

		List<WebElement> searchResults = driver.findElements(By.xpath("//ul//li//div[@role='option']"));

		System.out.println(searchResults.size());

		for (int i = 0; i < searchResults.size(); i++)
		{
			//System.out.println(searchResults.get(i).getText());
			
			
			  if (searchResults.get(i).getText().equals("selenium"))
			  {
			    searchResults.get(i).click();
			    Thread.sleep(3000);
			    break;
			  
			  }
			 

		}

		driver.quit();

	}
}
