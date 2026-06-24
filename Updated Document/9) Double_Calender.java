package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Double_Calender {
	static WebDriver driver = null;
	static WebDriverWait wait;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/hotel/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 1: Click the Calendar

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement waituntil = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='first_date_picker']")));
		waituntil.click(); 

		// Step 2: Take Month And Year // In double calendar always target left side
		// calendar

		String MyexpCheckinMonth_Year = "June 2026";
		String MyexoCheckinDate = "9";
		String MyexpCheckoutMonth_Year = "August 2026";
		String MyexoCheckoutDate = "30";

		Double_Calendar(MyexpCheckinMonth_Year, MyexoCheckinDate, MyexpCheckoutMonth_Year, MyexoCheckoutDate);
		
	}
	
	public static void Double_Calendar(String MyexpCheckinMonth_Year, String MyexoCheckinDate, String MyexpCheckoutMonth_Year, String MyexoCheckoutDate) {
		while (true) {
			String thismonthandyear = driver.findElement(By.xpath("(//h3[@aria-live='polite'])[1]")).getText(); // common xpath of month and year in left side calendar
			if (thismonthandyear.equals(MyexpCheckinMonth_Year)) {
				break;
			}
			driver.findElement(By.xpath("//button[@aria-label='Next month']//span[@aria-hidden='true']//*[name()='svg']")).click();
		}
		//Step 3: Take Date
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
		        .elementToBeClickable(By.xpath("(//table[@role='grid'])[1]//span[normalize-space()='"+MyexoCheckinDate+"']"))) // in MyexoCheckinDate u can replace with 9 is date  
		        .click();
		
		while (true) {
			String thismonthandyear = driver.findElement(By.xpath("(//h3[@aria-live='polite'])[1]")).getText();
			if (thismonthandyear.equals(MyexpCheckoutMonth_Year)) {
				break;
			}
			driver.findElement(By.xpath("//button[@aria-label='Next month']//span[@aria-hidden='true']//*[name()='svg']")).click();
		}
		//Step 3: Take Date
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
		        .elementToBeClickable(By.xpath("(//table[@role='grid'])[1]//span[normalize-space()='"+MyexoCheckoutDate+"']"))) // in 9 u can replace with MyexoCheckinDate 
		        .click();
	}
}
