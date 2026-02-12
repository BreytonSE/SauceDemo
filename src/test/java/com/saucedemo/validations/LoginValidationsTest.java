package com.saucedemo.validations;

import com.saucedemo.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginValidationsTest extends BaseTest {

    @Test(description = "User can log in with valid credentials")
    public void userCanLogInWithValidCredentials(){
        pages.loginPage().setUsername("standard_user");
        pages.loginPage().setPassword("secret_sauce");
        pages.loginPage().clickLoginButton();

        assertTrue(
                pages.inventoryPage().isAppLogoVisible(),
                "Inventory page is not visible after successful login."
        );
    }

    @Test(description = "User cannot log in with invalid credentials")
    public void userCannotLogInWithInvalidCredentials(){
        pages.loginPage().setUsername("john");
        pages.loginPage().setPassword("doe");
        pages.loginPage().clickLoginButton();

        assertFalse(
                pages.inventoryPage().isAppLogoVisible(),
                "Inventory page should not load after unsuccessful login."
        );
    }
}
