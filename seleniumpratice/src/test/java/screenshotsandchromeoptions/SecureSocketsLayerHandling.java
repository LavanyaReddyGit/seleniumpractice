package screenshotsandchromeoptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecureSocketsLayerHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();//This line we no need to write from selenium 4 version onwards
		
		  ChromeOptions options=new ChromeOptions();
		  options.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
