package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
@Test
	public void readData() throws EncryptedDocumentException, IOException
	{
	File path =new File("C:\\Users\\user\\Desktop\\login_file.xlsx");
	FileInputStream fis=new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	String gmail = sheet.getRow(0).getCell(0).toString();
	System.out.println("dws login mail id is:"+gmail);
	}
}
