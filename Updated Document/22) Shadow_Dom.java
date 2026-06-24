 package all_hw; 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow_Dom {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		//Step 1: Find the Parent shadow_host it will be the 1st shadow_host above the #shadow-root
		WebElement Parent_Host = driver.findElement(By.xpath("//div[@id='userName']"));
		
		//Step 2: Switch inside parent shadoe_root
		SearchContext parent_root = Parent_Host.getShadowRoot();
		
		//Step 3: Work inside parent element now
		parent_root.findElement(By.cssSelector("#kils")).sendKeys("Thasif");
		
		// if You needed to work inside nested shadow to work in child element
		
		//Step 4 : use parent_root // because its in nested shadow so we taking parent shadow 
		WebElement child_Host1 = parent_root.findElement(By.cssSelector("#app2"));
		
		//Step 5: Switch inside child shadoe_root
		SearchContext child_root1= child_Host1.getShadowRoot();
		
		//Step 6: Work inside child 1 element now
		child_root1.findElement(By.cssSelector("#pizza")).sendKeys("chicken");
		
		// Step 7: Handle closed shadow do use actions class // we vant even find css selector to locate element // nested closed shadow
		
		WebElement child_Host2 = parent_root.findElement(By.cssSelector("#concepts"));
		//child_Host2.click(); // use this if its not in nested shadow dom 
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("123456").perform();
		
		// Step 8: Handle closed shadow do use actions class // we vant even find css selector to locate element // not nested closed shadow // use scroll
		
		WebElement password = driver.findElement(By.xpath("//div[@id='userPass']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",password);
		Thread.sleep(5000);
		password.click();
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.TAB).sendKeys("123456").perform();
		
		// Step 9: If shadow dom open or close is inside iframe 1st we need to switch to ifram then we need to work on shadow dom 

	}

}
