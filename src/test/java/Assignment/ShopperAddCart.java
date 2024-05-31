package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ShopperAddCart extends ShopperStackBase {

	@Test
	public void addProduct() throws InterruptedException
	{
		Actions act=new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		act.moveToElement(men).build().perform();
		act.click().build().perform();
		
		driver.findElement(By.xpath("//a[text()='T-shirts']")).click();
		Thread.sleep(2000);
		List<WebElement> addCart = driver.findElements(By.xpath("//button[text()='add to cart']"));
		for (WebElement web : addCart) {
			
			web.click();
			Thread.sleep(2000);
			
		}
		
		
	}
}
