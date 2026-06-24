package Calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class new_child_calendar extends parent_calendar {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement calendar =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datepicker']")));
        calendar.click();
        
        new_child_calendar CC = new new_child_calendar();
        
        String expMonthYear = "June 2026";
        String actMonthYear_xpath = "//div[@class='ui-datepicker-title']";
        String nextbutton = "//a[@title='Next']//span";
        String date = "//table[@class='ui-datepicker-calendar']//a[text()='9']";
        
        CC.Single_calendar(driver, expMonthYear, actMonthYear_xpath, nextbutton, date);

	}

}
