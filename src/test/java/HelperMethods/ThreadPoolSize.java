package HelperMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	
	@Test(priority = 3,invocationCount = 2)  //negative will execute first
	public void demo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.close();
	}
	@Test(priority = 0)
	public void MumbaiI()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.mumbaiindians.com/");
		driver.close();
	}
	@Test(priority = 2)
	public void csk()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		driver.close();
	}
	
	@Test(priority = 1,invocationCount = 2, threadPoolSize = 2)
	public void rcb()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		driver.close();
	}

}
