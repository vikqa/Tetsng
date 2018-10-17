package com.gl.smoke.pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gl.smoke.excel.WorkFlowInfo;
import com.gl.smoke.pom.core.Dashboard;
import com.gl.smoke.pom.core.GenerateTests;
import com.gl.smoke.selenium.web.BrowserDriver;

public class DemoWorkflow {
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
	
	@DataProvider
	public Object[][] getValidData() {

		Object[][] data = WorkFlowInfo.getValidData();
		return data;

	}

	@Test(groups = { "Fantional Tests" }, priority = 1, description = "Verify Workflow",dataProvider = "getValidData")
	public void workflow(String site, String user, String pass, String email,
			String epass) {
		_dashboard = _tests.workflow(site, user, pass, email, epass);
		_dashboard
				.verifyWelcomeAlert("Welcome! You have signed up successfully.");

	}
}
