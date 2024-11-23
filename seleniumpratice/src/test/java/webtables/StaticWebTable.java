package webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://testautomationpractice.blogspot.com/");
		 
		 //To find total no.of rows
		 
	   int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
	   System.out.println("total no.of rows:"+rows);//if we have multiple tables we need to write specific xpath
		
		//System.out.println(driver.findElements(By.tagName("tr")).size());// if we have single table
		
		//System.out.println("total no.of rows:"+rows);
		
		//total no.of columns
		
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("total no.of cols:"+cols);
		
		//To read particular value from the table
		
		String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(value);// expected Master In Selenium
		
		
		//To print all the values of a table
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		
		for(int r=2;r<=rows;r++) //rows
		{
			for(int c=1;c<=cols;c++)
			{
				String values=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(values+"\t");
			}
			System.out.println();
			
			
		}
		
		//To get the values based on conditions
		
		
		for(int r=2;r<=rows;r++)
		{
			 String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			 if(authorName.equals("Mukesh"))
			 {
				 String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				 System.out.println(bookName+"\t"+authorName);
			 }
		}
		
		//To print all prices of the book
		
		int total=0;
		for(int r=2;r<=rows;r++)
		{
			 String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			 
			 total=total+Integer.parseInt(price);
			
			 
		}
		System.out.println(total);
		
		
		
		driver.quit();
		
		
	}

}
