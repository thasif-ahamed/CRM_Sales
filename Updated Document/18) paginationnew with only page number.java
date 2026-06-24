import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paginationnew {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // total pages
        List<WebElement> pages =driver.findElements(By.xpath("//ul[@id='pagination']//li"));
        int totalPages = pages.size();  // in this table o/p is 4
        

        // LOOP ALL PAGES
        for (int p = 1; p <= totalPages; p++) {

            // click page
            driver.findElement( By.xpath("//ul[@id='pagination']//li[" + p + "]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='productTable']")));

            // get all rows
            List<WebElement> rows =driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
            
            for (WebElement row : rows) {

                String name = row.findElement(By.xpath("td[2]")).getText();

                if (name.equalsIgnoreCase("Smartphone") ||
                    name.equalsIgnoreCase("Router")) {

                    WebElement checkbox = row.findElement(By.xpath("td[4]/input"));

                    checkbox.click();

                    System.out.println("Checkbox clicked for: " + name);
                }
            }

           
        }

        driver.quit();
    }
}


