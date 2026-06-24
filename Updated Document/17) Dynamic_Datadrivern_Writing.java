import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Dynamic_Datadrivern_Writing {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestDataExcel\\myfile_Dynamic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Dynamic_Data");
		XSSFRow row1 = sheet.createRow(0);
		
		// take the input from the user 
		
		Scanner sc = new Scanner(System.in); // syntax
		
		System.out.println("Enter how many rows");
		int noOfRows = sc.nextInt();
		
		System.out.println("Enter how many Column");
		int noOfColumn = sc.nextInt();
		
		
		
		for(int r= 0; r<=noOfRows; r++) {
			
			XSSFRow currentrow = sheet.createRow(r); // this line will create new row in excel 
			
			for(int c=0; c<noOfColumn; c++) {
				XSSFCell cell = currentrow.createCell(c); // this line will create cells in excel 
				cell.setCellValue(sc.next()); // this sc.next means user can enter data in the cell both string and int 
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is Created");

	}

}
