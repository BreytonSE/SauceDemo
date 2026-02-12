package com.saucedemo.managers;

import com.microsoft.playwright.*;

public class DriverManager {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initBrowser(){
        boolean isCI = System.getenv("CI") != null;

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(isCI) // Headless only in CI
        );

        context = browser.newContext();
        page = browser.newPage();

        return page;
    }

    public void closeBrowser(){
        if(context != null){
            context.close();
        }

        if(browser != null){
            browser.close();
        }

        if(playwright != null){
            playwright.close();
        }
    }
}