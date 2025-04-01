package DDTPractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\AdvanceSelenium\\src\\test\\resources\\Testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("DDT");
//		Row row = sh.getRow(1);
//		Cell cell = row.getCell(2);
//		String campaign = cell.getStringCellValue();
//		System.out.println(campaign);
		
		String campaign = wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();
		double targetSize = wb.getSheet("DDT").getRow(1).getCell(3).getNumericCellValue();
		System.out.println(campaign);
		System.out.println(targetSize);
		
		
	}

}
//this is reading data from excel file