package com.deftsoft.demo.pom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.deftsoft.demo.pom.or.TopNavigationOR;
import com.deftsoft.demo.pom.or.TopNavigationprofileOR;
import com.deftsoft.demo.selenium.wrapper.Helper;
import com.deftsoft.demo.selenium.wrapper.Wrapper;
import com.sun.jna.platform.win32.Advapi32Util.Account;

public class TopNavigationprofile {
	final static Logger logger = Logger.getLogger(TopNavigationprofile.class);
	private WebDriver driver;

	public TopNavigationprofile(WebDriver driver) {
		this.driver = driver;
	}

public Login logout(){
	clickforlogout();
	Helper.holdon(2);
	clickLogout();
	return new Login(driver);

}

public MyAccount account(){
	clickforlogout();
	Helper.holdon(2);
	clickAccount();
	return new MyAccount(driver);

}
private void clickforlogout() {
	try {
		Wrapper.clickElement(driver, TopNavigationOR.LBL_MY_ACCOUNT);
		logger.info("clickforlogout button clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("clickforlogout button does not exist", ex);
		logger.info("Error in clickforlogout method", ex);
		throw new IllegalArgumentException("clickforlogout element does not exists");
	} 
}


private void clickLogout() {
	try {
		Wrapper.clickElement(driver, TopNavigationprofileOR.SUB_LBl_Logout);
		logger.info("clickLogout button clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("clickLogout button does not exist", ex);
		logger.info("Error in clickLogout method", ex);
		throw new IllegalArgumentException("clickLogout element does not exists");
	} 
}

private void clickAccount() {
	try {
		Wrapper.clickElement(driver, TopNavigationprofileOR.SUB_LBl_Account);
		logger.info("clickLogout button clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("clickLogout button does not exist", ex);
		logger.info("Error in clickLogout method", ex);
		throw new IllegalArgumentException("clickLogout element does not exists");
	} 
}
}

