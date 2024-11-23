package dropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {

     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
     Thread.sleep(2000);
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     Thread.sleep(2000);
     
     driver.findElement(By.xpath("//span[text()='PIM']")).click();//click on pim
     
     
     Thread.sleep(2000);
     driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//span[normalise-space()='Account Assistant']")).click();
     Thread.sleep(2000);
     
     driver.quit();

	}

}
