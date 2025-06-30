package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
public class LoginTest {

	@Test
	public void loginTest() {

		HomePage homePage = new HomePage(EDGE);
		MyAccountPage accountPage = homePage.goToLoginPage().doLoginWith("padagi8671@iridales.com", "password");
		System.out.println(accountPage.getUserName());          
        
	}

}
