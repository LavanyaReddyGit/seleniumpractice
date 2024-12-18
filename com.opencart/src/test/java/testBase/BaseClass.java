package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BaseClass {
	
	public static  WebDriver driver;
	public Logger logger;
	public  Properties pr;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException
	{
	
		//loading log4j2 file
		
		logger=LogManager.getLogger(this.getClass());
				
		//loading properties file
		
		FileReader fread=new FileReader("./src//test//resources//config.properties");
		pr=new Properties();
		pr.load(fread);
		
		if(pr.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("Invalid os name");
				return;
			}
			
			//browsername
			
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox" : capabilities.setBrowserName("firefox");break;
			default : System.out.println("no matching browser"); return;
			}
			
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		
		//local
		
		if(pr.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//loading browser based on condition
			
			
			
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver();break;
			case "edge"   : driver=new EdgeDriver();break; 
			case "firefox" : driver=new FirefoxDriver(); break;
			default: System.out.println("Invalid browser"); return;
			}
		}
			
				
		driver.get(pr.getProperty("appurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies(); 
		
		
		
	}
	
	
	public String randomeAlphabetics() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
		
	}
	
	public String randomeNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	
	public String randomeAlphaNumeric()
	{
		String alphaNumeric=RandomStringUtils.randomAlphanumeric(5);
		return alphaNumeric;
	}
	
	public String captureScreen(String tname)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+"_"+".png";
		
		File targetfile=new File(targetfilepath);
		
		srcfile.renameTo(targetfile);
		
		return targetfilepath;
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	

}
