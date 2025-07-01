package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
public class LoginTest {
	HomePage homePage;
	@BeforeMethod(description = "Load the Home Page")
	public void setup() {
		homePage = new HomePage(EDGE);
	}

	@Test(description = "Verify valid login", groups={"smoke", "e2e"})
	public void loginTest() {
		String userName = homePage.goToLoginPage().doLoginWith("padagi8671@iridales.com", "password").getUserName();
		assertEquals(userName, "Suresh Rao");    
	}

}
