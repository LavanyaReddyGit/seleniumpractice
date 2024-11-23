package fileupload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//We can upload by using sendKeys() method
		
		
		/*
		 * driver.findElement(By.xpath("//input[@id='filesToUpload']"))
		 * .sendKeys("E:\\Pavansirseleniumcourse\\FileUploadPractice\\Test1.txt");
		 */
		 
		 //validation
		 
			/*
			 * if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals(
			 * "Test1.txt")) { System.out.println("File uploaded successfully"); } else {
			 * System.out.println("upload failed"); }
			 */
		 
		 // multiple files upload
		 //for this we should not use two send keys method
		 
		 
		 String file1="E:\\Pavansirseleniumcourse\\FileUploadPractice\\Test1.txt";
		 String file2="E:\\Pavansirseleniumcourse\\FileUploadPractice\\Test2.txt";
		 
		 driver.findElement(By.xpath("//input[@id='filesToUpload']"))
		 .sendKeys(file1+"\n"+file2);
		 
		 //no.of files upload validation
		 
		int noOffFilesUploaded= driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		if(noOffFilesUploaded==2)
		{
			System.out.println("All files are uploaded");
		}
		
		else
		{
			System.out.println("File are not uploaded");
		}
		//names validation
		
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.txt")&&
				driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test2.txt"))
			{
			  System.out.println("Files names matched");
			}
		else
		{
			System.out.println("Files names not matched");
		}
		 
		 

	}

}
