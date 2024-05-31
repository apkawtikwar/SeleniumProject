package TestNgBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GiftCard extends BaseClass {
	
	@Test
	public void giftCard() throws InterruptedException
	{
		driver.findElement(By.cssSelector("img[alt='Picture of $25 Virtual Gift Card']")).click();
		List<WebElement> text_field = driver.findElements(By.xpath("//input[@type='text']"));
		String [] arr = {"Aditi","Aditi@gmail.com","Anita","Anita@gmail.com","","",""};
		
		int i = 0;
		for (WebElement web : text_field) {
			web.sendKeys(arr[i++]);
			//Thread.sleep(2000);
		}
	}

}
