package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ShopperStackBase {
	
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
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		driver.get("https://www.shoppersstack.com/");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
		
	}
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException, InterruptedException
	{
		File path =new File("C:\\Users\\user\\Desktop\\shopperstacklogin.xlsx");
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		String gmail = sheet.getRow(0).getCell(0).toString();
		String password=sheet.getRow(0).getCell(1).toString();
		
		
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.id("Email")).sendKeys(gmail);
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='A']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Logout']")).click();
		
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
