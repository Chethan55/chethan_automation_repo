package com.ctl.it.qa.sample.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ctl.it.qa.sample.tools.steps.bundle_validation;
import com.ctl.it.qa.sample.tools.steps.user.UserSteps;
import com.ctl.it.qa.staf.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;


public class StepDefinition {
	@Steps
	UserSteps userSteps;
	
	@Before
	public void beforeEveryScenario(Scenario scenario) {
		Serenity.setSessionVariable("file_type").to(scenario.getName());
	}
	
	@BeforeStep
	public void beforeStep(Scenario scn) throws Exception {
		userSteps.captureScenarioSteps(scn);
	}
	
	@After
	public void afterEveryScenario(Scenario scenario) {
		try {
			com.ctl.it.qa.staf.Steps.isInitialized = false;
			Page.isInitialized = false;
			scenario.log("Data used for this test case:" + "\r\n");
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) userSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png","scenario");
			}
		}catch(Exception e) {
			
		}finally {
			userSteps.captureTestResult(scenario);
			userSteps.getDriver().close();
			userSteps.getDriver().quit();
			
		}	
	  }
	@Steps
	bundle_validation steps;
	
	@Given("I am in Karaf Tool page")
	public void i_am_in_karaf_tool_page() throws InterruptedException {
	    
		
		steps.Karaf_Tool_page();
		
		
	}

	@When("I login with my credentials")
	public void i_login_with_my_credentials() throws InterruptedException {
	    
		steps.login();
	}

	@When("I select {string} in App Name dropdown")
	public void i_select_in_app_name_dropdown(String string) throws InterruptedException {
	    
		
		steps.app_nam_drp_dwn(string);
	}

	@When("I click on resolve bundles button")
	public void i_click_on_resolve_bundles_button() throws InterruptedException {
	    
		steps.resolve_bundles_click();
	}

	@Then("I verify only activemq-blueprint bundles are in resolve state")
	public void i_verify_only_activemq_blueprint_bundles_are_in_resolve_state() throws InterruptedException {
	   
		steps.verify_activeMQ();
		
		
	}

}



