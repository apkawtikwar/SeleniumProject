package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Assignment_Scrolling extends AssignmentDWS_Base {
	@Test
	public void scrolling() throws InterruptedException
	{
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    Actions act=new Actions(driver);
		WebElement follow_us = driver.findElement(By.xpath("//div[@class='column follow-us']"));
		String parent_handle = driver.getWindowHandle();
		js.executeScript("arguments[0].scrollIntoView(true)",follow_us);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		for (WebElement web : links) {
			
			String rss="RSS";
			if(web.getText().equals(rss))
			{
				act.keyDown(Keys.CONTROL).build().perform();
				web.click();
			}
			else
			{
			web.click();
			driver.switchTo().window(parent_handle);
			Thread.sleep(2000);
			
			}
			
		}
	}

}
