package com.Pom_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Class {
	WebDriver driver;
	public Pom_Class(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}
	
	///Login page:
	
	//Email Box
	@FindBy(xpath="//input[@placeholder='Enter email']")
	public WebElement emailBox;
	
	//------------------------------------------------------------
	
	//Password Box
	@FindBy(xpath="//input[@placeholder='Enter password']")
	public WebElement passwordBox;
	
	//------------------------------------------------------------
	
	//Login button
	@FindBy(xpath="//button[normalize-space()='Log In']")
	public WebElement loginButton;
	
	//------------------------------------------------------------
	
	//loged In
	@FindBy(xpath="//button[normalize-space()='Log In']")
	public WebElement dashBoardPage;
	
	//------------------------------------------------------------
	
}
