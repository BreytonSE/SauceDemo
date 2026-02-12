package com.saucedemo.pages;

import com.microsoft.playwright.Page;

import static com.saucedemo.locators.InventoryLocators.APP_LOGO;

public class InventoryPage {
    private final Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    public boolean isAppLogoVisible(){
        return page.locator(APP_LOGO).isVisible();
    }
}