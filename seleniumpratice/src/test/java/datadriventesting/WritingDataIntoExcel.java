package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		//Writing use FileOutPutStream
		//Static Data
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"//testdata//datawrite.xlsx");
		
		XSSFWorkbook workBook=new XSSFWorkbook();
		
		XSSFSheet sheet=workBook.createSheet("Data");
		
		XSSFRow Row1=sheet.createRow(0);
		Row1.createCell(0).setCellValue(90.876544);
		Row1.createCell(1).setCellValue("BTS");
		Row1.createCell(2).setCellValue(true);
		
		XSSFRow Row2=sheet.createRow(1);
		Row2.createCell(0).setCellValue("Lavanya");
		Row2.createCell(1).setCellValue(9087);
		Row2.createCell(2).setCellValue(89.65);
		
		
		XSSFRow Row3=sheet.createRow(2);
		Row3.createCell(0).setCellValue(false);
		Row3.createCell(1).setCellValue("JK");
		Row3.createCell(2).setCellValue("V");
		
		workBook.write(file);
		workBook.close();
		file.close();
		
		
		

	}

}