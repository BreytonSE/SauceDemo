package com.saucedemo.managers;

import com.microsoft.playwright.Page;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

public class PageObjectManagers {
    private Page page;

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public PageObjectManagers(Page page) {
        this.page = page;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        return loginPage;
    }

    public InventoryPage inventoryPage() {
        if (inventoryPage == null) {
            inventoryPage = new InventoryPage(page);
        }
        return inventoryPage;
    }
}