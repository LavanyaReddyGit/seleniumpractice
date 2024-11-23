package screenshotsandchromeoptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessTesting {

	public static void main(String[] args) {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.amazon.in/");
//		
//		
//		
//		System.out.println(driver.getTitle());
//		driver.quit();
		
		//Headless Execution
		
		ChromeOptions options=new ChromeOptions();
		
    	options.addArguments("--headless=new");
    	
    	 WebDriver driver=new ChromeDriver(options);
    	 
    	 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
	
		
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
