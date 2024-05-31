package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasic1 {
	
	@Test(dataProvider = "login")
	public void receiver(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		//Click on Login Button
		driver.findElement(By.cssSelector("a[class='ico-login']")).click();
		//Enter the email
		driver.findElement(By.cssSelector("input[class='email']")).sendKeys(username);
		//Enter the password
		driver.findElement(By.cssSelector("input[class='password']")).sendKeys(password);
		//Click on login button
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.close();
		
		}
	
	@DataProvider(name = "login")
	public Object[][] sender(){
		
		Object[][] obj = new Object [2][2];
		obj[0][0]="admin01@gmail.com";
		obj[0][1]="admin01";
		obj[1][0]="admin02@gmail.com";
		obj[1][1]="admin02";
		
		return obj;
		//return DataProviderUtility.dwsLogin();
	}

}
