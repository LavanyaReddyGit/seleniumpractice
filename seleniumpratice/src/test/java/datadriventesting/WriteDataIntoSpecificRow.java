package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoSpecificRow {

	public static void main(String[] args) throws IOException {
	
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"//testdata//specificrow.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("data");
		
		XSSFRow row4=sheet.createRow(3); // index starts from 0
		
		XSSFCell cell=row4.createCell(4); // index starts from 0
		cell.setCellValue(false);
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		

	}

}
