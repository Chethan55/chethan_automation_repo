package com.ctl.it.qa.sample.tests;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ctl.it.qa.staf.Environment;
import com.ctl.it.qa.staf.HtmlReport;
import com.ctl.it.qa.staf.STAFEnvironment;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;

import io.cucumber.junit.CucumberOptions;



@TestEnvironment(Environment.PRODUCTION) // Test Environment on which execution is to happen is provided
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", tags = "@DSP_bundles")
public class CukesTest {

    @BeforeClass
    public static void setEnvironment() {
        STAFEnvironment.registerEnvironment(CukesTest.class);
        Steps.initialize("sample.xml"); // Ensure this initializes the steps object correctly
    }

    @AfterClass
    public static void clearEnvironment() {
        HtmlReport.generate(); // To generate customized Html report
    }
}