package screenshotsandchromeoptions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//Full page
		/*
		 * try { driver.get("https://www.amazon.in");
		 * 
		 * TakesScreenshot ts=(TakesScreenshot) driver; File
		 * sourcefile=ts.getScreenshotAs(OutputType.FILE); //Here we take screenshot
		 * through takescreenshot interface reference variable File targetDir=new
		 * File(System.getProperty("user.dir")+"//screenshots");
		 * 
		 * if(!targetDir.exists()) { targetDir.mkdir(); } File targetfile=new
		 * File(targetDir,"fullpage.png");
		 * 
		 * if(sourcefile.renameTo(targetfile)) {
		 * System.out.println("File saved successfully"+targetfile.getAbsolutePath()); }
		 * else { System.out.println("file not saved"); }
		 * 
		 * } finally { driver.quit(); }
		 */
		
		//Specific area of the page
			
			
		/*
		 * try { driver.get("https://www.amazon.in");
		 * 
		 * TakesScreenshot ts=(TakesScreenshot) driver; WebElement
		 * eightPMdeals=driver.findElement(By.xpath(
		 * "(//div[@class='dcl-container-inner'])[1]")); File
		 * sourcefile=eightPMdeals.getScreenshotAs(OutputType.FILE); //Here we take
		 * screenshot through takescreenshot interface reference variable File
		 * targetDir=new File(System.getProperty("user.dir")+"//screenshots");
		 * if(!targetDir.exists()) { targetDir.mkdir(); } File targetfile=new
		 * File(targetDir,"8PMdeals.png");
		 * 
		 * if(sourcefile.renameTo(targetfile)) {
		 * System.out.println("File saved successfully"+targetfile.getAbsolutePath()); }
		 * else { System.out.println("file not saved"); }
		 * 
		 * } finally { driver.quit(); }
		 */
		
			
			//Specific element
		
		try 
		{
			driver.get("https://www.amazon.in");
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			WebElement shopNow=driver.findElement(By.xpath("//img[@alt='Big Savings, More Happiness']"));
			
			File sourceFile=shopNow.getScreenshotAs(OutputType.FILE);
			File targetDir=new File(System.getProperty("user.dir")+"//screenshots");
			
			if(!targetDir.exists())
			{
				targetDir.mkdir();
			}
			
			File targetFile=new File(targetDir,"shopNow.png");
			
			if(sourceFile.renameTo(targetFile))
			{
				System.out.println("File successfully saved"+targetFile.getAbsolutePath());
			}
			else
			{
				System.out.println("File not saved");
			}
		}
		finally
		{
			driver.quit();
		}
		
		
		
		
		
		
		
		
		

	}

}
