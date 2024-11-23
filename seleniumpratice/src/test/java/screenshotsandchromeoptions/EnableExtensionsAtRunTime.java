package screenshotsandchromeoptions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		File selectorHub=new File("E:\\Pavansirseleniumcourse\\Extension\\SelectorsHub.crx");
		
		 ChromeOptions options=new ChromeOptions();
		 options.addExtensions(selectorHub);

		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in");
		
		
		
	}

}
