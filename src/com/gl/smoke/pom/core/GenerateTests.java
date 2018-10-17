package com.gl.smoke.pom.core;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.gl.smoke.pom.or.GenerateTestsOR;
import com.gl.smoke.selenium.wrapper.Helper;
import com.gl.smoke.selenium.wrapper.Wrapper;
import com.gl.smoke.utilities.ReportLog;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateTests {
	private WebDriver driver;

	public GenerateTests(WebDriver driver) {
		this.driver = driver;
		Helper.waitForBrowserToLoad(driver);
		Wrapper.explicitWaitForElementToBeClickable(driver,
				GenerateTestsOR.BTN_ANALYZE_MY_APP, 120);
	}

	public void verifyPageLoad() {
		String error = "";
		String result = error;
		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_ANALYZE_SITE_ACTIVE);

			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Analyze Tab highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Analyze tab should be highlighted";
			ReportLog.addToReportLog("Analyze tab should be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_GENERATE_TEST);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Generate Test Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Generate Test Tab should not be highlighted";
			ReportLog.addToReportLog("Generate Test Tab should not be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_CREATE_ACCOUNT);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Create account Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "";
			ReportLog.addToReportLog("Create account Tab should not be highlighted", LogStatus.WARNING);

		}
		if (!result.equals(error)) {			
			throw new IllegalArgumentException(error);
			
		}
	}

	public void verifyAnalyzeMyApp(String anyValue) {
		enterAnalyzeMyAppDetails(anyValue);
		ReportLog.addToReportLog("Analyze My App Details entered", LogStatus.PASS);
		String error = "";
		String result = error;
		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_ANALYZE_SITE);

			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Analyze Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Analyze Tab should not be highlighted";
			ReportLog.addToReportLog("Analyze Tab should not be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_GENERATE_TEST_ACTIVE);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Genertate test Tab highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Genertate test Tab should be highlighted";
			ReportLog.addToReportLog("Genertate test Tab should be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_CREATE_ACCOUNT);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Create account Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Create account Tab should not be highlighted";
			ReportLog.addToReportLog("Create account Tab should not be highlighted", LogStatus.WARNING);

		}
		if (!result.equals(error)) {
			throw new IllegalArgumentException(error);
		}
	}

	public void verifyEnterCredentialsForMySiteCom() {
		Wrapper.clickElementAndWait(driver,
				GenerateTestsOR.LINK_ENTER_CREDENCIAL_FOR_MY_SITE);
		ReportLog.addToReportLog("Enter Credentials For MySite Com link clicked", LogStatus.PASS);

	}

	public void verifyGenerateTest(String user, String pass) {
		enterGenerateTestDetails(user, pass);
		ReportLog.addToReportLog("Generate Test Details entered", LogStatus.PASS);
		String error = "";
		String result = error;
		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_ANALYZE_SITE);

			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Analyze Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Analyze Tab should not be highlighted";
			ReportLog.addToReportLog("Analyze Tab should not be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_GENERATE_TEST);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Generate Test Tab not highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Generate Test Tab should not be highlighted";
			ReportLog.addToReportLog("Generate Test Tab should not be highlighted", LogStatus.WARNING);
		}

		try {
			boolean flag = Wrapper.isElementDisplayed(driver,
					GenerateTestsOR.TAB_CREATE_ACCOUNT_ACTIVE);
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("Create Account Tab highlighted", LogStatus.PASS);
		} catch (Throwable e) {
			error += "Create Account Tab should be highlighted";
			ReportLog.addToReportLog("Create Account Tab should be highlighted", LogStatus.WARNING);
		}
		if (!result.equals(error)) {			
			throw new IllegalArgumentException(error);
		}
	}

	public Dashboard verifyCreateAccount(String email, String pass) {
		enterCreateAccountDetails(email, pass);
		ReportLog.addToReportLog("Create Account details entered", LogStatus.PASS);
		return new Dashboard(driver);

	}

	public Dashboard workflow(String site, String user, String pass, String email,
			String epass) {
		enterAnalyzeMyAppDetails(site);
		ReportLog.addToReportLog("Analyze My App Details entered", LogStatus.PASS);
		verifyEnterCredentialsForMySiteCom();
		ReportLog.addToReportLog("Enter Credentials For MySite Com link clicked", LogStatus.PASS);
		enterGenerateTestDetails(user, pass);
		ReportLog.addToReportLog("Generate Test Details entered", LogStatus.PASS);
		enterCreateAccountDetails(email, epass);
		ReportLog.addToReportLog("Create Account details entered", LogStatus.PASS);
		return new Dashboard(driver);

	}

	private void enterGenerateTestDetails(String user, String pass) {
		Wrapper.enterValueInInputBox(driver,
				GenerateTestsOR.TXT_USERNAME_GENERATE, user);
		Wrapper.enterValueInInputBox(driver,
				GenerateTestsOR.TXT_PASSWORD_GENERATE, pass);
		Wrapper.clickElementAndWait(driver, GenerateTestsOR.BTN_GENERATE_TEST);
		Wrapper.waitForPageActive(driver, GenerateTestsOR.WAIT);
	}

	private void enterCreateAccountDetails(String email, String pass) {
		Wrapper.enterValueInInputBox(driver,
				GenerateTestsOR.TXT_EMAIL_CREATE_ACCOUNT, email);
		Wrapper.enterValueInInputBox(driver,
				GenerateTestsOR.TXT_PASSWORD_CREATE_ACCOUNT, pass);
		Wrapper.clickElementAndWait(driver, GenerateTestsOR.BTN_CREATE_ACCOUNT);
	}

	private void enterAnalyzeMyAppDetails(String anyValue) {
		Wrapper.enterValueInInputBox(driver, GenerateTestsOR.TXT_WEB_APP_URL,
				anyValue);
		Wrapper.clickElementAndWait(driver, GenerateTestsOR.BTN_ANALYZE_MY_APP);
		Wrapper.waitForPageActive(driver, GenerateTestsOR.WAIT);
	}

}
