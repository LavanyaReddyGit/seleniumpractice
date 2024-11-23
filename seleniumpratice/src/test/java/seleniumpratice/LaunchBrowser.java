package seleniumpratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver=new ChromeDriver();
		 
		 driver.get("https://www.demoblaze.com/index.html");
		  List<WebElement> links=driver.findElements(By.tagName("a"));//no.of links
		  System.out.println(links.size());
		 List <WebElement> images=driver.findElements(By.tagName("img"));//no.of images
		 System.out.println(images.size());
        // driver.findElement(By.linkText("Home ")).click();
         driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
         String expTitle=driver.getTitle();
         if(expTitle.equals("STORE"))
         {
        	 System.out.println("Test case passed");
         }
         else
         {
        	 System.out.println("Test case failed");
         }
         Thread.sleep(5000);
         driver.quit();
	}
	
  

}


