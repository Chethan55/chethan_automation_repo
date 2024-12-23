package com.ctl.it.qa.sample.tools.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class bundle_validation_actions  extends LumenPage {

	
	
	
	@FindBy(xpath = "/html/body/div[2]/form/div[1]/input[1]")
	public WebElementFacade user_name;
	
	
	@FindBy(xpath = "/html/body/div[2]/form/div[1]/input[2]")
	public WebElementFacade pass;
	
	
	@FindBy(xpath = "/html/body/div[2]/form/div[1]/button")
	public WebElementFacade log_btn;
	
	
	@FindBy(xpath = "//*[@id='dropdown']")
	public WebElementFacade app_drp;
	
	@FindBy(xpath = "/html/body/form/div/div/div[5]/button")
	public WebElementFacade res_btn;
	
	@FindBy(xpath = "/html/body/div[3]/p")
	public WebElementFacade res_text;
	
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
