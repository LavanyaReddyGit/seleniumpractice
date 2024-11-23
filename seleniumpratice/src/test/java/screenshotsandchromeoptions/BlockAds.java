package screenshotsandchromeoptions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockAds {

	public static void main(String[] args) {
		
		File file=	new File("E:\\Pavansirseleniumcourse\\Extension\\uBlock.crx");
		
		ChromeOptions options=new ChromeOptions();
		options.addExtensions(file);
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://text-compare.com/");
		//uBlock-Origin
		//AdBlocker
		
		
		
	 
	 
	 

	}

}
