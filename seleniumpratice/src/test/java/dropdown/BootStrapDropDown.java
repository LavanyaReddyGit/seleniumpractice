package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//span[contains(@class,'multiselect')]//parent::button")).click();
		
		Thread.sleep(3000);
		//To select individual
		
		driver.findElement(By.xpath("//input[@value='jQuery']")).click();
		
		//To slect multiple
		
		
		//2) capture all the options and find out size
				List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
				System.out.println("Number of options:"+options.size()); //14
				
				//3) printing options from dropdown
				for(WebElement op:options)
				{
					System.out.println(op.getText());
				}
				
				
				//4) select multiple options
				for(WebElement op:options)
				{
					String option=op.getText();
					
					if(option.equals("Java") || option.equals("Python") || option.equals("MySQL"))
					{
						op.click();
					}
				}

	}

}
