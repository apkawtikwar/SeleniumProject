package Assertions;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 extends BaseClass_Assert{
	@Test
	public void assertSoft()
	{
		String expected_result="https://demowebshop.tricentis.com/";
		String actual_result = driver.getCurrentUrl();
		
		SoftAssert ass=new SoftAssert();
		boolean result = expected_result.equals(actual_result);
		ass.assertTrue(result);
		driver.findElement(By.id("small-searchterms")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		ass.assertAll();
	}

}
