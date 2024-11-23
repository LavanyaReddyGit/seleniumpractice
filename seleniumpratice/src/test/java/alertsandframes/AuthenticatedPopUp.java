package alertsandframes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		
		//This type of pop-up's we have to bypass by providing username and password in url
		//syntax
		//example url
		
		//http://username:password@the-internet.herokuapp.com/basic_auth
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(3000);
		driver.quit();

	}

}
