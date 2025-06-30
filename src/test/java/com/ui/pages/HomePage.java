package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

public final class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	public HomePage(Browser browser) {
		super(browser);
		goToWebsite("http://www.automationpractice.pl/index.php?");
		maximizeWindow();
	}
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
}
