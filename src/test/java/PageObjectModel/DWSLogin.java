package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pom.DWSLoginPage;

public class DWSLogin {

	@Test
	public void login() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/login");
		DWSLoginPage dws=new DWSLoginPage(driver);
		Thread.sleep(2000);
//		dws.email.sendKeys("aditikawtikwar@gmail.com");
//		Thread.sleep(2000);
//		dws.password.sendKeys("Aditi@123");
//		Thread.sleep(2000);
//		dws.login.click();
		
		dws.username("aditikawtikwar@gmail.com");
		dws.password("Aditi@123");
		dws.login_page();
	}
}
