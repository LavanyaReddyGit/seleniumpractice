package excelutils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		
		String filepath=System.getProperty("user.dir")+"//testdata//caldata.xlsx";
		int rows=ExcelUtil.getRowCount(filepath, "sheet1");
		
		//get data from excelfile
		for(int r=1;r<=rows;r++)
		{
			String principle=ExcelUtil.getCellData(filepath, "Sheet1", r, 0);
			String roi=ExcelUtil.getCellData(filepath, "Sheet1", r, 1);
			String per1=ExcelUtil.getCellData(filepath, "Sheet1", r, 2);
			String per2=ExcelUtil.getCellData(filepath, "Sheet1", r, 3);
			String frequency=ExcelUtil.getCellData(filepath, "Sheet1", r, 4);
			String exp_Mvalue=ExcelUtil.getCellData(filepath, "Sheet1", r, 5);
			
			//pass data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select s1=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			s1.selectByVisibleText(per2);
			
			Select s2=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			s2.selectByVisibleText(frequency);
			
			//click on calculate button
			driver.findElement(By.xpath("(//div[@class='CTR PT15']//img)[1]")).click();
			
			
			//Validation
			
			String act_Mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_Mvalue)==Double.parseDouble(act_Mvalue))

			{
				System.out.println("Test passed");
				
				ExcelUtil.setCellValue(filepath, "Sheet1", r, 7, "passed");
				ExcelUtil.fillGreenColour(filepath, "Sheet1", r, 7);
			}
			else
			{
              System.out.println("Test failed");
				
				ExcelUtil.setCellValue(filepath, "Sheet1", r, 7, "failed");
				ExcelUtil.fillRedColour(filepath, "Sheet1", r, 7);
			}
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			
			
		}
		
		driver.quit();
		
		
		
		

	}

}
