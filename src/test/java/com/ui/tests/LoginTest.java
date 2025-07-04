package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
public class LoginTest {
	HomePage homePage;
	@BeforeMethod(description = "Load the Home Page")
	public void setup() {
		homePage = new HomePage(EDGE);
	}

	@Test(description = "Verify valid login", groups={"smoke", "e2e"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider" )
	public void loginTest(User user) {
		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		assertEquals(userName, "Suresh Rao");    
	}
	
	@Test(description = "Verify valid login", groups={"smoke", "e2e"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider" )
	public void loginTestCSV(User user) {
		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		assertEquals(userName, "Suresh Rao");    
	}


}
