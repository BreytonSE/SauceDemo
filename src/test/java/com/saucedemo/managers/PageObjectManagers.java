package com.saucedemo.managers;

import com.microsoft.playwright.Page;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;

import java.lang.reflect.Field;

public class PageObjectManagers {
    private static PageObjectManagers instance;
    private Page page;

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    public PageObjectManagers(Page page) {
        this.page = page;
    }

    public static synchronized PageObjectManagers getInstance(Page page) {
        if (instance == null || page.isClosed()) {
            instance = new PageObjectManagers(page);
        }
        return instance;
    }

//    Keep this here for now. If not used, remove.
    public void updatePage(Page newPage){
        this.page = newPage;
        resetCachedPageObjects();
    }

//    Keep this here for now. If not used, remove.
    public static void reset(){
        instance = null;
    }

    private void resetCachedPageObjects(){
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.getName().endsWith("Page")){
                field.setAccessible(true);
            }
            try {
                field.set(this, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
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