package javascriptexecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoominZoomOut {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		
		//Thread.sleep(3000);
		
		//driver.manage().window().minimize();
		
		//Thread.sleep(3000);
		
		//driver.manage().window().maximize();
		
		//Zoom in
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(3000);
		
		js.executeScript("document.body.style.zoom='80%'");

	}

}
