package Test_Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.Base_Class.Base_Class;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\Featurefile", 
				 glue = "com.StepDefnition", 
				 publish = true, 
				 plugin = {
						 	"pretty", 
						 	"html:target/CucumberReport.html", 
						 	"json:target/Cucumber.json",
						 	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
		 				  }, 
				 dryRun = false, 
				 //tags = "@Test", 
				 monochrome = false) 
public class Test_Runner extends Base_Class{
	
	
	@BeforeClass
	public static void Startup() {
		browserLaunch();
		
	}

	@AfterClass
	public static void end() {
		quit();
	}
	

}
