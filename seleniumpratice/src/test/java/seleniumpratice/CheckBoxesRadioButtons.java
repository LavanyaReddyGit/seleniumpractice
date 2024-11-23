package seleniumpratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesRadioButtons {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//to select particular checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//To know the checkboxes count
		
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		System.out.println("No.of checkboxes:"+checkBoxes.size());
		
		//To check all the checkboxes
		Thread.sleep(300);
		
		/*
		 * for(int i=0;i<checkBoxes.size();i++) { checkBoxes.get(i).click(); }
		 */
		
		/*
		 * for(WebElement chBoxes:checkBoxes) { chBoxes.click(); }
		 * 
		 * Thread.sleep(300);
		 * 
		 * 
		 * //To uncheck all the checkboxes // for loop or for each loop both are fine
		 * 
		 * for(int i=0;i<checkBoxes.size();i++) { checkBoxes.get(i).click(); }
		 */
		
		//To select last three checkboxex
		//total checkboxes are 7
		//indesx should starts from 0
		
		/*
		 * for(int i=4;i<checkBoxes.size();i++) { checkBoxes.get(i).click(); }
		 */
		
		
		//To select first 4
		
		/*
		 * for(int i=0;i<=checkBoxes.size()-4;i++) // or i<checkBoxes.size()-3 {
		 * checkBoxes.get(i).click(); }
		 */
		//if we want to check based the selected condition
		
		
		for(int i=0;i<checkBoxes.size();i++)
		{
	
				checkBoxes.get(i).click();
			
		}
		for(int i=0;i<checkBoxes.size();i++)
		{
			if(checkBoxes.get(i).isSelected())
			{
				checkBoxes.get(i).click();
			}
		}
		
		Thread.sleep(3000);
		
		
	}

}
