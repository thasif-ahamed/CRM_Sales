package com.StepDefnition;

import com.Base_Class.Base_Class;
import com.Pom_Class.Pom_Class;

import io.cucumber.java.en.*;

public class StepDefnition extends Base_Class{
	
	Pom_Class pom = new Pom_Class(driver);
	
	@When("User enters valid email {string} in email field")
	public void user_enters_valid_email_in_email_field(String validEmail) {
		sendKeys(pom.emailBox,validEmail);
	}

	@When("User enters valid password {string} in password field")
	public void user_enters_valid_password_in_password_field(String validPassword) {
		sendKeys(pom.passwordBox,validPassword);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		JSClick(pom.loginButton);
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		isDisplay(pom.dashBoardPage);
	}


}
