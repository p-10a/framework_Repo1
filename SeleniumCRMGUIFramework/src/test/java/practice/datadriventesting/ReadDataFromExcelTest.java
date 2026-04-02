package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		//step 1:get the Excel path location & java object of the physical ExcelFlile
		FileInputStream fis=new FileInputStream("‪‪C:\\Users\\s\\Desktop\\data\\testScriptdata.xlsx");
		
		//step 2:open workBook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//step 3:get the control of the "org" sheet
		Sheet sh=wb.getSheet("org");
		
		//step 4:get the control of the "1st" Row
		Row row=sh.getRow(1);
		
		//step 5:get the control of the "2nd" cell & read the String data
		Cell cel=row.getCell(2);
		String data=cel.getStringCellValue();
		System.out.println(data);
		
		//step 6:close the workBook
		wb.close();
	}

}
