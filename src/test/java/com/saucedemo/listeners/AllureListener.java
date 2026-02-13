package com.saucedemo.listeners;

import com.saucedemo.utilities.AllureReportUtil;
import org.testng.IExecutionListener;

public class AllureListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("Starting Test Execution...");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test finished. Generating Allure report...");
        AllureReportUtil.generateAllureReport();
    }
}