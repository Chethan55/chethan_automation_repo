package com.ctl.it.qa.sample.tools.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.sample.tools.pages.bundle_validation_actions;
import com.ctl.it.qa.sample.tools.steps.user.UserSteps;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class bundle_validation extends LumenSteps{
	@Steps
	bundle_validation_actions actions;

	private static Logger LOGGER = LoggerFactory.getLogger(UserSteps.class);
	
	
	public void Karaf_Tool_page() throws InterruptedException {
		
		String url = envData.getFieldValue("url");
		LOGGER.debug("Launching URL: {}", url);
		LOGGER.warn("Browser is running is window mode.");
	
		getDriver().get(url);
		getDriver().manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("opend");
	}
	
	public void login() throws InterruptedException {
		
		System.out.println("entering");
		//String cuid = envData.getFieldValue("tbx_user_name");
		
		//String pass = envData.getFieldValue("tbx_password");
		
		actions.user_name.sendKeys("AD07234");
		actions.pass.sendKeys("Qwertyuiop331991*");
		
		Thread.sleep(2000);
		
		actions.log_btn.click();
		
		Thread.sleep(5000);
	
	}
	
	public void app_nam_drp_dwn(String app_name) throws InterruptedException {
		
		actions.app_drp.click();
		Thread.sleep(2000);
		
		 WebElement dropdownElement = actions.app_drp ;

	        Select s = new Select(dropdownElement);
	        s.selectByValue(app_name);
	        Thread.sleep(2000);
		
	}
	
	public void resolve_bundles_click() throws InterruptedException {
		
		actions.res_btn.click();
		
		  Thread.sleep(10000);
	}
	
	public void verify_activeMQ() throws InterruptedException {
		
		String a = actions.res_text.getText();
		
		Thread.sleep(2000);
		
		String[] lines = a.split("\n");
		

        // Verify each resolved line contains only "activemq-blueprint"
        for (int i = 2; i < lines.length; i += 2) { // Start from the third line and skip every other line
            String line = lines[i];
            System.out.println(lines[i]);
            
            if (line.contains("[Resolved]")) {
                Assert.assertTrue("Unexpected bundle found in resolved line: " + line, line.contains("activemq-blueprint"));
            }
		
       
       }
        
        System.out.println("-------------------------------------------------");
	}
	
	
}
