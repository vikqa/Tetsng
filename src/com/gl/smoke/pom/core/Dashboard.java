package com.gl.smoke.pom.core;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.gl.smoke.pom.or.DashboardOR;

import com.gl.smoke.selenium.wrapper.Helper;
import com.gl.smoke.selenium.wrapper.Wrapper;
import com.gl.smoke.utilities.ReportLog;
import com.relevantcodes.extentreports.LogStatus;

public class Dashboard {
	private WebDriver driver;
	public Dashboard(WebDriver driver) {
		Helper.waitForBrowserToLoad(driver);
		Wrapper.explicitWaitForElementToBeClickable(driver,
				DashboardOR.ALERT, 120);
	}
	
	public void verifyWelcomeAlert(String str){
		boolean flag = Wrapper.isElementDisplayed(driver, DashboardOR.ALERT);
		try{
			Assert.assertEquals(flag, true);
			ReportLog.addToReportLog("", LogStatus.PASS);
		}catch(Throwable e){
			ReportLog.addToReportLog("", LogStatus.FAIL);
			throw new IllegalArgumentException("");
		}
	}
	
	

}
