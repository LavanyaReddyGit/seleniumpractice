package keyboardevents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_Slider=driver.findElement(By.xpath("//span[@style='left: 0%;']"));
		System.out.println("default location of the min_slider:"+min_Slider.getLocation());//59,249
		Actions act=new Actions(driver);
		//this slider is horizontal
		//we have to increase x axis
		
		act.dragAndDropBy(min_Slider, 100, 249).perform(); //59+100
		System.out.println("After moving of the min_slider:"+min_Slider.getLocation()); // nearly 159
		
		
		//Maximum slider
		
		WebElement max_Slider=driver.findElement(By.xpath("//span[@style='left: 100%;']"));
		
		System.out.println("Default location of the max_slider:"+max_Slider.getLocation());
		
		act.dragAndDropBy(max_Slider,-100, 249).perform(); //544-100
		System.out.println("After moving of the max_slider:"+max_Slider.getLocation()); // nearly 444
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
