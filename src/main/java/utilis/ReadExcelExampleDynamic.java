package utilis;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelExampleDynamic {

	public static String [][] readData(String filename) throws IOException {
		//To get the workbook
		XSSFWorkbook wb=new XSSFWorkbook("./data/createlead.xlsx");
		//To get the sheet form workbook
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
       //To get the No.of.Rows in the sheet with exclude the 1st row
		int rowCount = sheet.getLastRowNum();
		
		//To get the No.of.Rows in the sheet include the 1st row
		//	int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		
		//To get the No.of.cells in the row
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data=new String [rowCount][cellCount];
		//To iterate each row
		for (int i = 1; i <= rowCount; i++) {
			//To get the row
			XSSFRow row=sheet.getRow(i);
			//To iterate each cell
			for (int j = 0; j < cellCount; j++) {
				//To get the cell
				XSSFCell cell=row.getCell(j);
				//To get the data in cell
				String value = cell.getStringCellValue();
				
				data[i-1][j]=value;
				
				//to print the value
				System.out.println(value);
			}

		}
		return data;

	}

}
