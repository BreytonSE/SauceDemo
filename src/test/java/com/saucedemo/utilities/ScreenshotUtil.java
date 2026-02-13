package com.saucedemo.utilities;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    private static final String SCREENSHOT_DIR = "target/screenshots/";

    private ScreenshotUtil() {
//        Prevents instantiation
    }

    public static void capture(Page page, String fileName) {
        try{
            createScreenshotDirectory();
            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String fullFileName = fileName + "_" +  timeStamp + ".png";
            Path path = Paths.get(SCREENSHOT_DIR + fullFileName);

//            Takes screenshot as byte array
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setFullPage(true));

//            Save to file
            Files.write(path, screenshot);

            System.out.println("Screenshot saved at: " + fullFileName);

//            Attach to Allure
            Allure.addAttachment(
                    "Screenshot - " + fileName,
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );

        }catch (Exception e){
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    private static void createScreenshotDirectory() throws IOException {
        Path path = Paths.get(SCREENSHOT_DIR);
        if (!Files.exists(path)){
            Files.createDirectories(path);
        }
    }
}