package Assignment;

import java.io.IOException;
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
import org.testng.annotations.Parameters;

public class AssignmentDWS_Base {
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite()  
	{
		System.out.println("Connecting to database");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Precondition for test runner");
	}
	@Parameters("url")
	@BeforeClass
	public void beforeClas(String url)
	{
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		
	}
	@Parameters({"username","password"})
	@BeforeMethod
	public void beforeMethod(String username,String password)
	{
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(By.cssSelector("a[class='ico-logout']")).click();
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException
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
