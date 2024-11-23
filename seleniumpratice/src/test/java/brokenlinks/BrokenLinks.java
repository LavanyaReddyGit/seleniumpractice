package brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.deadlinkcity.com/");
		
		//capture all the links from website
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total no.of links"+allLinks.size());
		
		int noOfBrokenLinks=0;
		for(WebElement link:allLinks)
		{
		    String hrefValue=link.getAttribute("href");
		    if(hrefValue==null ||hrefValue.isEmpty())
		    {
		    	System.out.println("href attribute is null or empty, so it's impossible to check");
		    	continue;
		    }	
		    	
		    	//connect to the server
		    	try
		    	{
		    		URL url=new URL(hrefValue);
			    	HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			    	conn.connect();
			    	
			    	if(conn.getResponseCode()>=400)
				    {
				    	System.out.println(hrefValue+"Broken link");
				    	noOfBrokenLinks++;
				    }
			    	 else
					    {
					    	System.out.println(hrefValue+"not a broken link");
					    }
			   
		    	}
		    	catch(Exception e)
		    	{
		    		
		    	}
		    	
		    	
		    }
		System.out.println(noOfBrokenLinks);
		    
		}
	

	}
		
		

	


