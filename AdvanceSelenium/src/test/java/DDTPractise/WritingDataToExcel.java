package DDTPractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//wb.createSheet("WriteData").createRow(1).createCell(2).setCellValue("Selenium"); //create new worksheet
		wb.getSheet("DDT").createRow(2).createCell(0).setCellValue(2000); //create row and cell in existing worksheet
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\Testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("Data Written successfully");
	
	}

}
