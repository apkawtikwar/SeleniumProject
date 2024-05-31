package Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	WebDriver driver=new ChromeDriver();
	@BeforeClass
	public void beforeClas()
	{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://demoapps.qspiders.com/ui/formValidation?sublist=0");
	}
	@Test
	public void formValidate() throws InterruptedException
	{
		Thread.sleep(200);
		driver.findElement(By.xpath("//input[@name='requiredfield']")).sendKeys("hello");
	}

//	@AfterClass
//	public void afterClass()
//	{
//		driver.close();
//	}
	
	

}


