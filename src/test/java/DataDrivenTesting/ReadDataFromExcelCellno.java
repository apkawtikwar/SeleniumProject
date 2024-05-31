package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelCellno {
	@Test
	public void readData() throws EncryptedDocumentException, IOException {
		File path = new File("C:\\Users\\user\\Desktop\\login_file.xlsx");
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
         String s1 = sheet.getRow(0).getCell(0).toString();
		String s2 = sheet.getRow(0).getCell(1).toString();
		String s3 = sheet.getRow(1).getCell(0).toString();
		String s4 = sheet.getRow(1).getCell(1).toString();
		System.out.println("DWS login mail id: " +s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

}
