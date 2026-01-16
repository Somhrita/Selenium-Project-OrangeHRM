package com.orangeHRM.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.HomePage;

public class LoginPageTest extends BaseClass {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setupPages() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }
    
    @Test
    public void verifyValidLoginTest() {
    	loginPage.login("Admin", "admin123");
    	org.testng.Assert.assertTrue(homePage.isAdminTabVisible(),"Admin Tab should be visible after successfull login");
    	homePage.logout();
    	staticWait(2);
    }
    
    @Test
    public void verifyinValidLoginTest() {
    	loginPage.login("admin", "admin");
    	String expectedErrorMessage = "Invalid credentials1";
    	Assert.assertTrue(loginPage.verifyErrorMessage(expectedErrorMessage));
    }
}

