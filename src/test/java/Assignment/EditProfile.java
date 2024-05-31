package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditProfile extends ShopperStackBase{
	
	@Test
	public void editProfile() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.findElement(By.xpath("//div[text()='A']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='My Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Edit Profile')]")).click();
		Thread.sleep(2000);
		File path =new File("C:\\Users\\user\\Desktop\\ShopperProfile.xlsx");
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		String first_Name = sheet.getRow(0).getCell(0).toString();
		String last_name=sheet.getRow(0).getCell(1).toString();
		String dob=sheet.getRow(1).getCell(0).toString();
		String phone=sheet.getRow(1).getCell(1).toString();
		String coun=sheet.getRow(2).getCell(0).toString();
		String st=sheet.getRow(2).getCell(1).toString();
		String ct=sheet.getRow(3).getCell(0).toString();
		
		Actions act=new Actions(driver);
		
	    WebElement first = driver.findElement(By.id("First Name"));
		WebElement last = driver.findElement(By.id("Last Name"));
		WebElement birthDate = driver.findElement(By.xpath("(//input[@aria-invalid='false'])[3]"));
		WebElement phno = driver.findElement(By.id("Phone Number"));
		
		act.click(first).build().perform();
		 first.clear();
		 Thread.sleep(1000);
        act.sendKeys(first_Name).build().perform();
        
        act.click(last).build().perform();
         last.clear();
         Thread.sleep(1000);
        act.sendKeys(last_name).build().perform();
        
        act.click(birthDate).build().perform();
        birthDate.clear();
        Thread.sleep(1000);
        act.sendKeys(dob).build().perform();
        
        act.click(phno).build().perform();
        phno.clear();
        Thread.sleep(1000);
        act.sendKeys(phone).build().perform();
		
		WebElement country = driver.findElement(By.id("Country"));
		Select s1=new Select(country);
		s1.selectByVisibleText(coun);
		
		Thread.sleep(2000);
		
		WebElement state = driver.findElement(By.id("State"));
		Select s2=new Select(state);
		s2.selectByVisibleText(st);
		
		Thread.sleep(2000);
		
		WebElement city = driver.findElement(By.id("City"));
		Select s3=new Select(city);
		s3.selectByVisibleText(ct);
		
		driver.findElement(By.id("submit")).click();
		
		Alert alrt= driver.switchTo().alert();
		Thread.sleep(2000);
		alrt.accept();
		
		
		
		
	}
	
	}


