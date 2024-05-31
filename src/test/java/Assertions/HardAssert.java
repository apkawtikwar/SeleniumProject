package Assertions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssert extends BaseClass_Assert{
	
	@Test
	public void hardAssert()
	{
		String expected_result="https://demowebshop.tricentis.com/";
		String actual_result = driver.getCurrentUrl();
		
		assertEquals(expected_result,actual_result);
		driver.findElement(By.id("small-searchterms")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
	}

}
