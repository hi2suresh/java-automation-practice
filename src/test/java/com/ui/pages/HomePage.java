package com.ui.pages;

import static com.utility.PropertiesUtil.readProperty;

import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	public HomePage(Browser browser) {
		super(browser);	
		// goToWebsite(readProperty(QA, "URL"));
		String url = JSONUtility.readJSON(QA);
		System.out.println(url);
		goToWebsite(url);
		maximizeWindow();
	}
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
}
