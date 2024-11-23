package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//testdata//data.xlsx");
	
	XSSFWorkbook workBook=new XSSFWorkbook(fis);
	
    XSSFSheet sheet=workBook.getSheet("Sheet1");
    
  int noOfRows= sheet.getLastRowNum(); //5
  int noOfCells=sheet.getRow(1).getLastCellNum();//4
  
  for(int r=0;r<=noOfRows;r++)
  {
	  XSSFRow currentRow=sheet.getRow(r);
	  for(int c=0;c<noOfCells;c++)
	  {
	      XSSFCell currentCell=currentRow.getCell(c);
	      System.out.print(currentCell.toString()+"\t");
	  }
	  System.out.println();
  }
  
  workBook.close();
  fis.close();
	
	
		

	}

}
