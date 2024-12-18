package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static WebDriver driver;
	static Properties p;
	static Logger logger;

	public static WebDriver initializeBrowser() throws IOException
	{
		p=getProperties();
		String executionEnv=p.getProperty("execution_env");
		String browser=p.getProperty("browser").toLowerCase();
		String os=p.getProperty("os").toLowerCase();
		
		//remote
		if(executionEnv.equalsIgnoreCase("remote"))		
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			switch(os)
			{
			case "windows":  capabilities.setPlatform(Platform.WINDOWS);break;
			case "mac"    :  capabilities.setPlatform(Platform.MAC);break;
			default: System.out.println("Inavlid os name");
			return null;
			}
			
			
			switch (browser)
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "edge"   :  capabilities.setBrowserName("edge");break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			default: System.out.println("invalid browser name");
			return null;
			}
			
			
		  driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
			
		}
		
		//local
		
		else if(executionEnv.equalsIgnoreCase("local"))		
		{
			
			
			
			switch (browser.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver();break;
			case "edge"   :  driver=new EdgeDriver();break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default: System.out.println("invalid browser name");
			driver=null;

			}
				
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		return driver;
		
	}
	
	public static Properties getProperties() throws IOException
	{
		FileReader read=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(read);
		return p;
		
	}
	
	public static Logger getLogger()
	{
		logger=LogManager.getLogger();
		return logger;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public static String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
	
	public static String randomAlphaNumeric()
	{
		String alphanumeric=RandomStringUtils.randomAlphanumeric(5);
		return alphanumeric;
	}
}
