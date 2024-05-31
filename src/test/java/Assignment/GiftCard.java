package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GiftCard extends AssignmentDWS_Base{
	@Parameters({"reci_name","reci_email","sender_name","sender_email","msg","qty"})
	@Test
	public void giftCard(String reci_name,String reci_email, String sender_name,String sender_email,String msg,String qty )
	{
		driver.findElement(By.cssSelector("img[alt='Picture of $25 Virtual Gift Card']")).click();
		driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys(reci_name);
		driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys(reci_email);
		driver.findElement(By.id("giftcard_2_SenderName")).sendKeys(sender_name);
		driver.findElement(By.id("giftcard_2_SenderEmail")).sendKeys(sender_email);
		driver.findElement(By.id("giftcard_2_Message")).sendKeys(msg);
		WebElement quantity = driver.findElement(By.id("addtocart_2_EnteredQuantity"));
		quantity.clear();
		quantity.sendKeys(qty);
	}

}
