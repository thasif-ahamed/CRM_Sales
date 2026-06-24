import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Excel {
	
	// Reading Data from excel 
	
	// Excel File – Work book – Sheet – Rows – Sells 
	
	//FileInputStream = reading file from excel
	
	
	//	XSSFWorkbook – Workbook
	//	XSSFSheat – Sheet
	//	XSSFRow – Row
	//	XSSFCell – Cell



	public static void main(String[] args) throws IOException {

		
		// Step 1: open file // Read Data from Excel File // Add excel here // enter the path of excel where we stored the excel file in eclips 
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestDataExcel\\Book1.xlsx"); // syntax except that path
		
		// Step 2: open Work book of the excel
		
		XSSFWorkbook workbook = new XSSFWorkbook(file); // syntax
		
		// Step 3: Sheet 
		
		XSSFSheet excel_sheet = workbook.getSheet("Sheet1"); // import excel sheat // Sheet 1 is the name of the Excel sheet 
		
		// Step 4: find all Rows and Cells in the Excel
		
		int total_Rows = excel_sheet.getLastRowNum(); // this will give us how many total number of rows are there in that excel sheet1 
		short total_Cells = excel_sheet.getRow(1).getLastCellNum(); // from that 1st row we will get the last column number are there in that sheet1
		
		System.out.println("Total number of Rows: "+total_Rows); // rows always starts from 0 // OP is 3
		System.out.println("Total number of Cells: "+total_Cells); // Column Starts from 1,2,3,4 // OP is 4
		
		for(int r=0; r<=total_Rows;r++) {
			
			XSSFRow currentrow = excel_sheet.getRow(r); // 1st we need to get the perticular rows from excel in loop finaly all row will come
			
			for(int c=0; c<total_Cells;c++) {
				
			XSSFCell cell = currentrow.getCell(c); // this will get all the cells from the loop row 
			System.out.print(cell.toString()+"\t"); // tostring is a methos that will concert data in string format 
		}
			System.out.println();
	}
		// Step 5 Close Workbook now 
		
		workbook.close();
		
		// Step 6 Close File now 
		
		file.close();

}	

}
