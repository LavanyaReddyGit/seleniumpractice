package keyboardevents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabVsWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://adactinhotelapp.com/");
		//To open the orangehrm in another tab
		
		//driver.switchTo().newWindow(WindowType.TAB);
		
		
		//To open the orange hrm in another window
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://orangehrm.com/");
		
		
		driver.quit();
		
	}

}
