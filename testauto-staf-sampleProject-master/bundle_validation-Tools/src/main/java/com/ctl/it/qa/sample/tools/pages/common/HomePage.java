package com.ctl.it.qa.sample.tools.pages.common;

import com.ctl.it.qa.sample.tools.pages.LumenPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends LumenPage {// Mandatory to extend all page classes with a common class which extends Page
											// class of STAF or directly extend with Page class of STAF

	/*
	 * Below are the ways in which objects are identified using different locators
	 * like id,LinkText,xpath,css,name,etc.. Follow the below naming convention for
	 * ElementFacade(MANDATORY) btn - button lbl - label lnk - link ddl - drop down
	 * list cbx - check box img - image tbx = text box
	 * 
	 */

	@FindBy(className = "cmp-header__navigation-item-contact")
	public WebElementFacade lnk_contact_us;
	
	@FindBy(xpath = "//button[contains(text(),'Accept Cookies')]")
	public WebElementFacade btn_Accept_Allcookies;

	@FindBy(id = "onetrust-accept-btn-handler")
	public WebElementFacade btn_accept_cookies;

	@FindBy(css = "span.search-icon")
	public WebElementFacade btn_search;
	
	@FindBy(css = "span.till-laptop .icon-menu")
	public WebElementFacade btn_menu;

	/*
	 * Method used in shouldExist & isExist method
	 */
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_search;
	}
}
