package mousehovering;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Guru99DragAndDropAssignment {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		
		
		// DEBIT_SIDE
		//Element(bank) needs to drag
		WebElement bank=driver.findElement(By.xpath("//*[@id='credit2']//a"));
		
		//Element(Debit_side) on which needs to drag
		WebElement debit_Bank= driver.findElement(By.xpath("//*[@id='bank']//li"));
		
		//Element(5000) needs to drag 
		
		WebElement amount=driver.findElement(By.xpath("//*[@id='fourth']//a"));
		
		//Element(debit_side amount)
		
		WebElement debit_Amount=driver.findElement(By.xpath("//*[@id='amt7']//li"));
		
		//CREDIT_SIDE
		
		//Bank button we can use same for both debit 7 credit side
		
		WebElement credit_Sales=driver.findElement(By.xpath("//*[@id='credit1']//a"));
		
		//Capture Account section from credit_side
		
		WebElement credit_Bank=driver.findElement(By.xpath("//*[@id='credit1']//a"));
		//Amount also we can use same
		
		//Capture Amount section from credit side
		
		WebElement credit_Amount=driver.findElement(By.xpath("//*[@id='amt8']//li"));
		
		
		
	  //Drag Bank& Ammount on  debit side
		
		Actions act=new Actions(driver);
		
		  act.dragAndDrop(bank, debit_Bank).build().perform();
		  
		  act.dragAndDrop(amount, debit_Amount).build().perform();
		 
		
		
		//Drag Bank & Amount on credit side
		
		/*
		 * act.dragAndDrop(credit_Sales, credit_Bank).build().perform();
		 * 
		 * act.dragAndDrop(amount, credit_Amount).build().perform();
		 */
		
		  
		  //driver.quit();
	}

}
