import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_Writing {
	
	// Writing Data from excel 
	// Excel File – Work book – Sheet – Rows – Sells 
	
	//FileOutputStream = Write data into excel 
	
	//	XSSFWorkbook – Workbook
	//	XSSFSheat – Sheet
	//	XSSFRow – Row
	//	XSSFCell – Cell

	
	public static void main(String[] args) throws IOException {
		
		// Step 1: We Created new excel file to write data
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestDataExcel\\myfile.xlsx");
		
		// Step 2: Create work book but dont put the file inside () 
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// Step 3: Create sheet 
		
		XSSFSheet sheet = workbook.createSheet("Data"); // data is my excel sheet name 
		
		// Step 4: Create Row 
		
		XSSFRow row1 = sheet.createRow(0); 
		
		// Step 5: Create cells 
		
		// this mean in row 1 we column 1 , 2 , 3 datas are passing 
		row1.createCell(0).setCellValue("Java"); 
		row1.createCell(1).setCellValue(12345);
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2 = sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue(19);
		row2.createCell(2).setCellValue("Automation");
		
		// Step 6: link file and workbook
		
		workbook.write(file); // connect wokebook with the file 
		workbook.close();
		file.close();
		
		System.out.println("File is Created");

	}

}
