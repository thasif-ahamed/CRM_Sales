import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {
	static WebDriverWait wait;
	 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker']")));
		calender.click();
		
		String MyexpMonth = "June";
		String MyexpYear = "2026";
		String MyexoDate = "9";
		
		Single_calendar(MyexpMonth, MyexpYear, MyexoDate);
	}
	
	public static void Single_calendar(String MyexpMonth, String MyexpYear, String MyexoDate) {
		
		while (true) {
			String actMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span)[1]")).getText(); // March
			String actYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();// 2026
			
			if (actMonth.equals(MyexpMonth) && actYear.equals(MyexpYear)) {
				break;
			}
				driver.findElement(By.xpath("//a[@title='Next']//span[text()='Next']")).click(); // xpath of next button in the calendar 
		}
		
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']//table//tbody//td//a[text()='" + MyexoDate + "']"))).click();

		
	}

}

--------------------------------------------------------------------------------------------------------------------------------------------

package Calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Child_Calendar extends Single_Calendar {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Child_Calendar cc = new Child_Calendar(); // Create Object to Call methods 
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker']")));
		calender.click(); 
		
		String expMonthYear = "June 2026";
		String expDate = "9";
		String actMonthYear = "//div[@class='ui-datepicker-title']";
		String nextbutton = "//a[@title='Next']//span";
		String date = "//table[@class='ui-datepicker-calendar']//tbody//tr//td//a[text()='"+expDate+"']";
		
		cc.Single_calendar(expMonthYear, expDate, actMonthYear, nextbutton, date);

	}

	// Method without Static so use object to call this method 
	
	public void Single_calendar(String monthyear, String date, String actMonthYearxpath, String nextbutton,String datexpath) {

		while (true) {
			String actMonthYear = driver.findElement(By.xpath(actMonthYearxpath)).getText();// April 2026
			if (actMonthYear.equals(monthyear)) {
				break;
			}
			driver.findElement(By.xpath(nextbutton)).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(datexpath))).click();

	}

}

