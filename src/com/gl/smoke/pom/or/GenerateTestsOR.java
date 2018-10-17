package com.gl.smoke.pom.or;

import org.openqa.selenium.By;

public class GenerateTestsOR {

	public static final By BTN_ANALYZE_MY_APP = By
			.cssSelector("input.onboardnew_submit.onclick_loading[value = 'Analyze My App']");
	public static final By TXT_WEB_APP_URL = By.id("web_app_url");
	
	public static final By WAIT = By.id("label");
	
	public static final By TXT_USERNAME_GENERATE = By.id("Username_generate");
	
	public static final By TXT_PASSWORD_GENERATE = By.id("Password_generate");
	
	public static final By BTN_GENERATE_TEST= By
			.cssSelector(".onboardnew_submit.onclick_loading[value='generate tests']");
	
	public static final By BTN_CREATE_ACCOUNT = By
			.cssSelector(".onboardnew_submit[value ='create account']");
	
	
	public static final By TXT_EMAIL_CREATE_ACCOUNT = By.id("user_email");
	
	public static final By TXT_PASSWORD_CREATE_ACCOUNT = By.id("user_password");
	
	
	public static final By LINK_ENTER_CREDENCIAL_FOR_MY_SITE = By.cssSelector("div.credentialsnew_btn a");

	public static final By TAB_ANALYZE_SITE_ACTIVE = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form1.tabsnew_active");

	public static final By TAB_ANALYZE_SITE = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form1:not(.tabsnew_active)");

	public static final By TAB_GENERATE_TEST_ACTIVE = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form2.tabsnew_active");

	public static final By TAB_GENERATE_TEST = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form2:not(.tabsnew_active)");

	public static final By TAB_CREATE_ACCOUNT_ACTIVE = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form3.tabsnew_active");

	public static final By TAB_CREATE_ACCOUNT = By
			.cssSelector(".tabsnew_leftsec.pade_none div.form3:not(.tabsnew_active)");

}
