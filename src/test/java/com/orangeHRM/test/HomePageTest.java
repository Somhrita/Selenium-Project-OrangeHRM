package com.orangeHRM.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;

public class HomePageTest extends BaseClass{
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		homePage  = new HomePage(getDriver());
	}
	@Test
	//@Test(dataProvider="validLoginData", dataProviderClass = DataProviders.class)
	public void verifyOrangeHRMLogo() {
		//ExtentManager.startTest("Home Page Verify Logo Test"); --This has been implemented in TestListener
		//ExtentManager.logStep("Navigating to Login Page entering username and password");
		loginPage.login("admin","admin123");
		//ExtentManager.logStep("Verifying Logo is visible or not");
		Assert.assertTrue(homePage.verifyOrangeHRMlogo(),"Logo is not visible");
		//ExtentManager.logStep("Validation Successful");
		homePage.logout();
		//ExtentManager.logStep("Logged out Successfully!");
	}


}
