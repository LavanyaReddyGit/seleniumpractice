package webtables.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		//find total pages
		int totalPages=driver.findElements(By.xpath("//ul//a")).size();
		System.out.println(totalPages);
		
		//click on each page
		
		int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		
		for(int p=1;p<=totalPages;p++)	
		{
			if(p>1)
			{
				driver.findElement(By.xpath("//ul//a[text()="+p+"]")).click();
				
			}
			//read the data from the pages
			System.out.println("id"+"\t"+"name"+"\t");
			
			for(int r=1;r<=rows;r++)
			{
				String iddata=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[1]")).getText();
				System.out.print(iddata+"\t");
				
				String nameData =driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[2]")).getText();
				System.out.print(nameData);
				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td//input[@type='checkbox']")).click();
				Thread.sleep(2000);
			}
			System.out.println(" ");
			
		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
