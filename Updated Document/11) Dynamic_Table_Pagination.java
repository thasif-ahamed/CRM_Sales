
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get(" https://demo3x.opencartreports.com/admin/"); 
		
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//a[@class=\"parent collapsed\"])[5]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		// Step 1: Find Page Number like this it will be there in the bottom of the table (Showing 1 to 20 of 25 (2 Pages))
		
		String Page_Number_Text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText(); // get the text of it (Showing 1 to 20 of 25 (2 Pages))
		System.out.println(Page_Number_Text); // O/P: Showing 1 to 20 of 26 (2 Pages) // in this we want the last page number only that is 2 here
		
		// Step 2 want to find the starting and ending index of the page number Showing 1 to 20 of 26 (2 Pages) entries in this we have to find for 2
		//Starting index is "(" and ending index is "Pages"
		
		Integer totalpage = Integer.valueOf(Page_Number_Text.substring(Page_Number_Text.indexOf("(") + 1, Page_Number_Text.indexOf("Pages")-1)); // syntax for finding page number in table
		System.out.println("Total number of pages in the table is: "+totalpage); // O/P: 2 
		
		// Step 3 Want to find total number of rows in each pages of the table
		
		// 1) the page number which is displayed in screen which is called active page so for that tag name will be span tag to get that us (for loop)
		
		for(int p=1; p<=totalpage; p++) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span")); // this the X path for active page number 1 which is displayed till <span> tag will be there and we have to find the x path // 1 2 > >| now the page 1 is active page u want to locate page 1 now in xpath 
			System.out.println("Active page number: "+active_page.getText()); // O/P: 1 because by in built active page number will be 1
			active_page.click(); // Simply Click page 1
			
			// 2 after clicking on 1st active page that is 1. Then get the total number of rows in that active page 1
			
			int total_numberofrowsin_Activepage = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size(); // get xpath from table

			System.out.println("Number of Rows in Active page: "+total_numberofrowsin_Activepage); // O/P: 20 in this 1st active page and 5 in 2nd active page as per this application
			
			// Read all row from Active page 1  // here we doing work in active page 1

			for(int r=1; r<=total_numberofrowsin_Activepage;r++) {
				WebElement status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[4]")); // all row in Active Page 1 column 4 we taking in x path from table
				System.out.println(status.getText()); // all the status column will print that is OP here options Shipped and Pending in this application here O/P is Shipped
				
				if(status.getText().equals("Shipped")) {
					String customer = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
					String Orderid = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
					System.out.println(customer + "  " +Orderid);
					
				}
				
			}
			
			
			// Step 4 now we are clicking on next page which is non active page as of now. In loop, So we have to find proper common x path the page that is not displayed they are all in <a> tag
			
			 if(p < totalpage) {
				 String curentactivepagenumber = Integer.toString(p+1); // +1 is given because already page 1 is active now move to page 2 as active we giving +1 // syntax
				 driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+curentactivepagenumber+"']")).click();// this will click next pages in loop // //ul[@class='pagination']//li//a[text()='2'] // this xpath will be down in showing page number 
			 }
			 

		}


	}

}
