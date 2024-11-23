package seleniumpratice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {

	public static void main(String[] args) throws MalformedURLException {
	
		WebDriver driver=new ChromeDriver();
		//driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen");
		 URL url=new URL("https://www.nopcommerce.com/en/register?returnUrl=%2Fen");
		 driver.navigate().to(url);
		// driver.navigate().to("https://www.nopcommerce.com/en/register?returnUrl=%2Fen");
		driver.manage().window().maximize();
		
		/*
		 * System.out.println(driver.getTitle());
		 * System.out.println(driver.getCurrentUrl());
		 * System.out.println(driver.getPageSource());
		 * System.out.println(driver.getWindowHandle()); ;
		 */
		
		
		
	
		
		

	}

}
