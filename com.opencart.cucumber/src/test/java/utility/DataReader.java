package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	
	public static List<HashMap<String,String>> data(String filepath,String sheetname) throws IOException
	{
		List<HashMap<String,String>> myData=new ArrayList();
		try
		{
			FileInputStream file=new FileInputStream(filepath);
			XSSFWorkbook workbook= new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			 Row headerRow=sheet.getRow(0);
		   for(int i=1;i<sheet.getPhysicalNumberOfRows() ;i++)
	             {
	        		
	                Row currentRow=sheet.getRow(i);
	             	HashMap<String,String> currentHash=new HashMap<String,String>();
	             	
	             	for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
	             	{
	             		Cell currentCell=currentRow.getCell(j);
	             		switch(currentCell.getCellType())
	             		{
	             		  case STRING:
	             		   currentHash.put(headerRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
	             		   break;
	             		}
	             		
	             	}
	             	myData.add(currentHash);
	             }
	             
	        	 file.close();
		         }
		 
        catch(Exception e)
        {
        	e.printStackTrace();
        }
       
		
		
		return myData;
    }

}
