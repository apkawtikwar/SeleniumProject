package TestNgBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite()  //execute only one time
	{
		System.out.println("Connecting to database");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Precondition for test runner");
	}
	
	@BeforeClass
	public void beforeClas()
	{
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys("aditikawtikwar@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Aditi@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(By.cssSelector("a[class='ico-logout']")).click();
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.close();
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post condition for test runner");
	}
	
	
	
	@AfterSuite
	public void afterSuite()  //execute only one time
	{
		System.out.println("disconnect for database");
	}


}
