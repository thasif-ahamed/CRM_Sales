package Calendar;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScript_Single_Calendar  {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		JavaScript_Single_Calendar sc = new JavaScript_Single_Calendar();
		WebElement Date_picker = driver.findElement(By.xpath("//input[@id='datepicker']"));
		sc.Jscalander(driver, "04/14/2026", Date_picker);
		
		
		

	}

	public void Jscalander(WebDriver driver, String texttobetype, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + texttobetype + "'", element);

	}

}
