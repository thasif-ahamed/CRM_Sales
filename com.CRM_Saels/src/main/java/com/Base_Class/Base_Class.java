package com.Base_Class;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class {

	// 1) Browser Launch:

	public static WebDriver driver;

	public static void browserLaunch() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://d1b2j2qkt1bss3.cloudfront.net/login");
	}

	// ---------------------------------------------------------------------------------

	// 2) Quit:

	public static void quit() {

		driver.quit();
	}

	// ---------------------------------------------------------------------------------

	// 2) SendKeys:

	public static void sendKeys(WebElement e, String text) {

		e.clear();
		e.sendKeys(text);
	}

	// ---------------------------------------------------------------------------------

	// 3) JS Click:

	public static void JSClick(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", e);
	}

	// ---------------------------------------------------------------------------------

	// 4) isDisplayed:

	public static void isDisplay(WebElement e) {

		e.isDisplayed();
	}

	// ---------------------------------------------------------------------------------

}
