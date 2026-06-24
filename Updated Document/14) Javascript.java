import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript {
	private static final String Thsif = null;
	public static JavascriptExecutor js;
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html"); 
		
		// 1 Javascript Click when normal click not working use this 
		
		/*WebElement button = driver.findElement(By.xpath("//button[normalize-space()='START']"));
		Jsclick(driver,button);
		WebElement search = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
		Jsclick(driver,search);*/
		
		// 2 Javascript border and screenshot an element this will make the element to creat border when it fails  
		
		/*WebElement button1 = driver.findElement(By.xpath("//button[normalize-space()='START']"));
		Jsborderandscreenshot(driver,button1);*/

		// 3 get title 
		
		//Jsgetttitle(driver);
		
		// 4 Send keys 
		
		/*WebElement namebox = driver.findElement(By.xpath("//input[@id='name']"));
		Jssendkeys(driver, "Thasif" , namebox);*/
		
		//5 Calendar 
		
		WebElement calaendar = driver.findElement(By.xpath("//input[@id='first_date_picker']"));

		Jscalander(driver, "06/09/2026" , calaendar);
		
		//5 Refresh page
		
		/*js = (JavascriptExecutor) driver;
		js.executeScript("history.go[0]");*/
		
		//6 copy all text in page
		textonoage(driver);

	}
	public static void Jsclick(WebDriver driver, WebElement element ) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void Jsborderandscreenshot(WebDriver driver, WebElement element ) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid black'", element);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(".\\screenshotsnew11\\fullbbpage.png");
		FileUtils.copyFile(sourcefile, targetfile);
	}
	public static void Jsgetttitle(WebDriver driver)  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String titleofpage = js.executeScript("return document.title").toString();
		System.out.println(titleofpage);
	}
	public static void JsgetURL(WebDriver driver)  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String titleofpage = js.executeScript("return document.URL").toString();
		System.out.println(titleofpage);
	}
	public static void Jssendkeys(WebDriver driver, String texttobetype, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+texttobetype+"'", element);
	}
	
	public static void Jscalander(WebDriver driver, String texttobetype, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+texttobetype+"'", element);
	}
	public static void textonoage(WebDriver driver) {
		
		js = (JavascriptExecutor) driver;
		String textonpage = js.executeScript("return document.documentElement.innerText").toString();
		System.out.println(textonpage);
		
	}

}
