package com.ctl.it.qa.sample.tests.steps.user;

import com.ctl.it.qa.sample.tools.pages.common.HomePage;
import com.ctl.it.qa.sample.tools.steps.user.UserSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;



public class UserStepDefinition {

	 @Steps
	 UserSteps endUser; //A Step class of Tools project is initialized with @Steps annotation
	
	 HomePage homePage;
	 
		@SuppressWarnings("static-access")
		@Given("^I am in Centurylink portal$")
	    public void I_am_on_Centurylink_portal() {
	    	String fileType=Serenity.sessionVariableCalled("file_type");//Serenity feature to store value and which can be used anywhere further in the script
	    	if(fileType.contains("excel")) {
	    		endUser.switchDataTo("sample.xlsx");//Method to switch between different input data
	    	}else {
	    		endUser.switchDataTo("sample.xml");
	    	}
	        endUser.is_on_centurylink_page();
	        
	    }
	   
		@Then("^I should be on contact page$")
		public void I_should_be_on_home_page() {
			endUser.navigate_to_contact_us_page();
		}
	  }
