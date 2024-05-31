package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Assignment1_prime {
	@Test
	public void readData() throws EncryptedDocumentException, IOException
	{
	File path =new File("C:\\Users\\user\\Desktop\\Sel_Assignment.xlsx");
	FileInputStream fis=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	
	int row = sheet.getPhysicalNumberOfRows();
	int column = sheet.getRow(0).getPhysicalNumberOfCells();
	
	for(int i = 0; i < row; i++) {
		for (int j = 0; j < column; j++) {
			String s = sheet.getRow(i).getCell(j).toString();
			int data = (int)Double.parseDouble(s);
			
			if(checkPrime(data))
			{
				System.out.println(data+"is a prime number");
			}
			else
			{
				System.out.println(data+"is not a prime number");
			}
			
		}
	}
}
	
	public static boolean checkPrime(int num)
	{
		
		if(num<=1)
		{
			return false;
		}
		int den=2;
		while(num>den)
		{
			if(num%den==0)
			{
				return false;
			}
			den++;
		}
		return true;
	}
}
	


