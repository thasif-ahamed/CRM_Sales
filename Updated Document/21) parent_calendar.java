package Calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parent_calendar {

	public static void main(String[] args) {
		

	}
	
	public void Single_calendar(WebDriver driver, String monthyear, String actMonthYearxpath, String nextbutton, String datexpath) {
		while (true) {
			String actMonthYear = driver.findElement(By.xpath(actMonthYearxpath)).getText();

			if (actMonthYear.equals(monthyear)) {
				break;
			}
			driver.findElement(By.xpath(nextbutton)).click();
		}
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(datexpath))).click();
	}

}
