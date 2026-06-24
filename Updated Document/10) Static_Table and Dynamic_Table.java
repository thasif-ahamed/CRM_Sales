import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Static_Table {
	static WebDriver driver = null;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		// 1) // Step 1: Find all rows in the table and find the size of the row how many rows are there in the table

		List<WebElement> total_table_rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr"));
		System.out.println("total rows in table:  " + total_table_rows.size());
		for(WebElement newtotal_table_rows:total_table_rows) {
			System.out.println(newtotal_table_rows.getText());
		}

		// 2) Find Number of Columns in table:

	/*	List<WebElement> total_table_Column = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//th"));
		System.out.println("total Column in table:  " + total_table_Column.size());

		// 3 Find Specific data in table if row 2 data 3

		List<WebElement> Secificdata_table = driver
				.findElements(By.xpath("//table[@name='BookTable']//tbody//tr[2]//td[3]"));
		for (WebElement Secificdata_tables : Secificdata_table) {
			String data = Secificdata_tables.getText();
			System.out.println(data);
		}

		// 4) Print all data in all rows and columns through dynamically

		for (int r = 1; r <= total_table_rows.size(); r++) { // time 1 r=1 the row = 1 true then it will check next

			for (int c = 1; c <= total_table_Column.size(); c++) { // time 1 c=1 the column = 1 true then it will check
																	// next
				List<WebElement> alldatas = driver
						.findElements(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]//td[" + c + "]"));
				for (WebElement newalldatas : alldatas) {
					String data = newalldatas.getText();
					System.out.println(data + "");
				}
			}
		}

		// 5) Get data from the table by specifying one data

		for (int r = 1; r <= total_table_rows.size(); r++) {
			List<WebElement> Name = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + r + "]//td[1]"));
			for (WebElement Names : Name) {
				String cname = Names.getText();
				// System.out.println(cname);

				if (cname.equals("Kishore") || cname.equals("Praveen")) {
					String place = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + r + "]//td[3]"))
							.getText();
					System.out.println(place);
				}
			}

		}*/
		
		// 6) Dynamic table Sample web site: https://practice.expandtesting.com/dynamic-table:
		
		// Step 1: Get all rows
		
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='myTable']//tbody//tr"));
		int rowCount = totalRows.size();

		// Step 2: Get the Static Column

		for (int r = 1; r <= rowCount; r++) {

		String ststic_column_name = driver.findElement(By.xpath("//table[@id='myTable']//tbody//tr[" + r + "]//td[2]")).getText();
		System.out.println(ststic_column_name);
			
		if(ststic_column_name.equals("Jane Smith")) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='myTable']//tbody//tr[" + r + "]//td[1]//input")));
		checkbox.click();
		break;
		}
		}
		}
		}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		for (int r = 1; r <= rowCount; r++) {

		String ststic_column_name = driver.findElement(By.xpath("//table[@id='myTable']//tbody//tr[" + r + "]//td[2]")).getText();
		String ststic_column_age = driver.findElement(By.xpath("//table[@id='myTable']//tbody//tr[" + r + "]//td[2]")).getText();
		//System.out.println(ststic_column_name);
			
		if(ststic_column_name.equals("Jane Smith") && ststic_column_name.age("20")) {
		String role = driver.findElement(By.xpath("//table[@id='myTable']//tbody//tr[\" + r + \"]//td[3]")).getText();
		String email = driver.findElement(By.xpath("//table[@id='myTable']//tbody//tr[\" + r + \"]//td[4]")).getText();
		System.out.print("his role is: "+ role +"  "+ "his emailid is:  "+email);
		}
		}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------


