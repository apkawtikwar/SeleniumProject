package ExtentReport;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClassDWS;
import com.crm.pom.DWSLoginPage;

@Listeners(com.crm.listenersCode.GenerateExtentReport.class)
public class reportWithGenerateTestCases extends BaseClassDWS{
	@Test
	public void dwsLoginCorrect() {
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		DWSLoginPage dws = new DWSLoginPage(driver);
		dws.username("admin01@gmail.com");
		dws.password("admin01");
		dws.login_page();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	@Test
	public void dwsLoginWrong() {
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		DWSLoginPage dws = new DWSLoginPage(driver);
		dws.username("admin01@gmail.com");
		dws.password("admin02");
		dws.login_page();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
	}

	@Test(dependsOnMethods = "dwsLoginWrong")
	public void redbus() {
		driver.get("https://www.redbus.in/");
		assertEquals("hi","bye");
	}
}
