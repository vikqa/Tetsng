package com.gl.smoke.pom.tests;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gl.smoke.commom.Common;
import com.gl.smoke.pom.core.Dashboard;
import com.gl.smoke.pom.core.GenerateTests;
import com.gl.smoke.selenium.web.BrowserDriver;
import com.gl.smoke.selenium.wrapper.TestCase;

public class DemoTests extends TestCase {

	final static Logger logger = Logger.getLogger(DemoTests.class);
	private WebDriver driver;
	private GenerateTests _tests;
	private Dashboard _dashboard;

	@Parameters({ "browserVer", "baseURL" })
	@BeforeClass
	public void setup(String browserVer, String baseURL) {

		driver = BrowserDriver.launchBrowser(browserVer);
		driver.navigate().to(baseURL);
		_tests = new GenerateTests(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}

	@Test(groups = { "Fantional Tests " }, priority = 1, description = "Verify Page Load functionality")
	public void To_Verify_Page_Load() {
		_tests.verifyPageLoad();

	}

	@Test(groups = { "Fantional Tests " }, priority = 2, description = "Verify Analyze My App Button functionality")
	public void To_Verify_Analyze_My_App_Button() {
		_tests.verifyAnalyzeMyApp("http://mezumanet.herokuapp.com/");

	}

	@Test(groups = { "Fantional Tests " }, priority = 3, description = "Verify Enter credentials for my site button functionality")
	public void To_Verify_Enter_Credentials_for_Mysitecom() {
		_tests.verifyEnterCredentialsForMySiteCom();
	}

	@Test(groups = { "Fantional Tests " }, priority = 4, description = "Verify Generate test button functionality")
	public void To_Verify_Generate_Test_Button() {

		String user = "test" + Common.getCurrentDateTime();
		String pass = "12345678";
		_tests.verifyGenerateTest(user, pass);
}

	@Test(groups = { "Fantional Tests " }, priority = 5, description = "Verify Create Account button functionality")
	public void To_Verify_Create_Account_Button() {
		String email = "test" + Common.getCurrentDateTime()
				+ "@glsolutions.com";
		String pass = "12345678";

		_dashboard = _tests.verifyCreateAccount(email, pass);
		_dashboard
				.verifyWelcomeAlert("Welcome! You have signed up successfully.");
	}

}
