import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://total-qa.com/checkbox-example/"); 
		
		// 1) Handle Single check box
		
		//driver.findElement(By.xpath("//div[@id='primary']//input[1]")).click();
		
		// 2) Click All checkbooks
		
		/*List<WebElement> checkboxs = driver.findElements(By.xpath("//div[@id='primary']//input")); // write common xpath which has all the check box
		
		System.out.println(checkboxs.size()); // 4 check boxes 
		
		for(WebElement newcheckboxs:checkboxs) {
			newcheckboxs.click();
		}*/
		
		// 3) Click multiple checkbooks by choice // in this we have to get the attribute of check box
		
		/*for(WebElement newcheckboxs:checkboxs) {
			String checkboxname = newcheckboxs.getAttribute("id"); // take the specific attribute 
			if(checkboxname.equals("Selenium") || checkboxname.equals("Selenium")) {
				newcheckboxs.click();
			}
		}*/
		
		// 4) There are 7 checkbox in that i have to click on last 2 checkboxs 
		
		// 1st we have to take how many check box are there in that specific place // in this case there are 4 check boxs
		
		// If I want to select last 2 we have to do total check boxs - 2 that is 4-2  if u want last 3 put - 3
		
		/*List<WebElement> allcheckboxs = driver.findElements(By.xpath("//div[@id='primary']//input")); // write common xpath which has all the check box
		int totalcheckbox = allcheckboxs.size(); // 4 check boxes 
		
		for(int i= totalcheckbox-2; i<totalcheckbox;i++) {
			allcheckboxs.get(i).click();
		}*/
		
		// 5) There are 7 checkbox in that i have to click on first 3 checkboxs
		
		List<WebElement> Callcheckboxs = driver.findElements(By.xpath("//div[@id='primary']//input")); // check box xpath
		
		
		for(int i= 0; i<Callcheckboxs.size();i++) {
				if(i<3) {
					Callcheckboxs.get(i).click();
				}
			}
		
		
		
		
		
		

		
		
		
		
		

	}

}
