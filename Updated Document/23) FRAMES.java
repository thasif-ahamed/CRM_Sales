package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FRAMES {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		// Switch to frame
		WebElement frame1 = driver.findElement(By.xpath("//frame[(@src='frame_1.html')]")); // this xpath is of 1st frame
		driver.switchTo().frame(frame1); // move into 1st frame
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome"); // do work
		// this will move to main page
		driver.switchTo().defaultContent();

		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));// this xpath is of 2nd frame

		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Thasif");
		driver.switchTo().defaultContent();

		// switch to inner Iframe (Inner Frame)

		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Thasif");

		// (Inner Frame part of frame 3)

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();

		// Switch to parent one step back
		driver.switchTo().parentFrame();
		WebElement newname = driver.findElement(By.xpath("//input[@name='mytext3']"));
		newname.clear();

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//span[contains(text(),'Clear form')]")).click();
		driver.findElement(By.xpath("(//span[@class='NPEfkd RveJvd snByac'])[7]")).click();

		// wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement choose = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Choose']")));
		choose.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Well, now I know :-)']"))).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("WelcomeAll");

	}

}
