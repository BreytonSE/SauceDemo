package com.saucedemo.base;

import com.microsoft.playwright.*;
import com.saucedemo.managers.DriverManager;
import com.saucedemo.managers.PageObjectManagers;
import com.saucedemo.utilities.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected PageObjectManagers pages;
    protected Page page;
    protected DriverManager driverManager;

    @BeforeMethod
    public void setUp(){
        driverManager = new DriverManager();
        page = driverManager.initBrowser();
        pages = new PageObjectManagers(page);

        page.navigate("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            ScreenshotUtil.capture(page,result.getName());
        }

        driverManager.closeBrowser();
    }
}