package com.ctl.it.qa.sample.tools.steps.user;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.sample.tools.pages.common.HomePage;
import com.ctl.it.qa.sample.tools.steps.LumenSteps;

import net.serenitybdd.annotations.Step;



@SuppressWarnings("serial")
public class UserSteps extends LumenSteps {

	private static Logger LOGGER = LoggerFactory.getLogger(UserSteps.class);

	HomePage homePage;
	
	

	@Step
	public void is_on_centurylink_page() {
		String url = envData.getFieldValue("url");
		LOGGER.debug("Launching URL: {}", url);
		LOGGER.warn("Browser is running is window mode.");
		homePage.maximize();
		LOGGER.debug("Browser maximized");
		homePage.openAt(url);
		shouldExist(homePage, 30);
		LOGGER.info("User is on LUMEN home page");
	}

	@Step
	public void navigate_to_contact_us_page() {
		if (homePage.btn_accept_cookies.isClickable()) {
			homePage.btn_accept_cookies.click();
		}
		if (homePage.btn_menu.isVisible()) {
			homePage.btn_menu.click();
			LOGGER.info("User clicked on homepage menu");
		}
		homePage.lnk_contact_us.click();
		LOGGER.info("User clicked on Contact us link");
		LOGGER.debug("Current URL:  {}", homePage.getDriver().getCurrentUrl());
		if (homePage.getDriver().getCurrentUrl().contains("contact-us")) {
			LOGGER.info("User is on contact us page");
		} else {
			LOGGER.error("User is not on contact us page");
		}

		if (!homePage.getTitle().contains("support")) {
			LOGGER.error("User is not on support page");
		}
	}

}
