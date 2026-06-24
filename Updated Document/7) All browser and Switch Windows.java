Method 1

package ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PP {

	public static String browser = "Chrome"; 
	public static WebDriver driver; 
	static Set<String> allwindows; 

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equals("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[normalize-space()='Open New Seperate Windows']")).click(); // parent window click

		String parentID = driver.getWindowHandle(); // get parent window ID
		System.out.println(parentID); // print parent window ID

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // parent window click + go to 1st child window

		allwindows = driver.getWindowHandles();
		System.out.println(allwindows);
		
		switchtorequiredwindows("Selenium"); // 1st child title name code last ah iruku ("String title")
		driver.manage().window().maximize(); // work in child window
		driver.switchTo().window(parentID);// switch back to parent window
		driver.findElement(By.xpath("//span[@class='fa fa-facebook-square']")).click(); // work in parent window

		allwindows = driver.getWindowHandles();// this is to tell system to focus 2nd child window
		switchtorequiredwindows("Automation Testing | Hyderabad  | Facebook"); // 2nd child title name code last ah iruku ("")
		driver.findElement(By.xpath("//div[@aria-label='Close']//i[@class='x1b0d499 x1d69dk1']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Forgotten account?']")).click();
		
		allwindows = driver.getWindowHandles();
		switchtorequiredwindows("Facebook");  // 3rd child title name code last ah iruku ("")
		Thread.sleep(5000); 
		driver.findElement(By.xpath("(//div[@role='none'])[2]")).click();
		driver.switchTo().window(parentID);

	}

	public static void switchtorequiredwindows(String title) {

		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {

			String win = itr.next();
			driver.switchTo().window(win);

			if (driver.getTitle().equals(title)) {

				break;

			}
		}

	}

}

------------------------------------------------------------------------------------------------------------------------------------------

Method 2

package Tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class swindowswitch {
	
	public static WebDriver driver;
	static JavascriptExecutor js;
	static List<String> ids;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String parentID = driver.getWindowHandle();
		System.out.println(parentID);
		Thread.sleep(5000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("iphone");
		Thread.sleep(3000);
		List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class=\"left-pane-results-container\"]/div")); 
		System.out.println(alloptions.size());
		for(WebElement newalloption :alloptions) {
			if(newalloption.getText().contains("iphone 13 case cover")) {
			newalloption.click();
			break; 
			} }
		
		driver.findElement(By.xpath("(//h2[contains(@class,'a-size-medium a-spacing-none')]//span)[1]")).click();
		
		// 2ND PAGE OPEN

		ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		

             	//THIS WILL SCROLL WHERE U WANT IN PAGE 2

		WebElement buynow = driver.findElement(By.xpath("//input[@id='buy-now-button']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",buynow);
		
		driver.findElement(By.xpath("(//a[@id='sellerProfileTriggerId'])[1]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Ask a question']")).click();
		
		// 3RD PAGE OPEN

		ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(2));
		driver.findElement(By.xpath("//input[@id='ap_email_login']")).sendKeys("986565");
		
		// 2ND PAGE OPEN

		ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		driver.navigate().back(); 
		
		// PARENT PAGE OPEN

		driver.switchTo().window(parentID);

		// 3RD PAGE OPEN

		ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(2));
	
		
	}

}
