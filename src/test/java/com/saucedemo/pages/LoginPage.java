package com.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.saucedemo.locators.LoginLocators.*;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void setUsername(String username) {
            page.locator(USERNAME_FIELD).fill(username);
    }

    public void setPassword(String password) {
            page.locator(PASSWORD_FIELD).fill(password);
    }

    public void clickLoginButton() {
            page.locator(LOGIN_BUTTON).click(new Locator.ClickOptions().setTimeout(5000));
    }
}