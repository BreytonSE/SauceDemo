package com.saucedemo.utilities;

import com.microsoft.playwright.Page;

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
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            Path path = Paths.get(SCREENSHOT_DIR + fileName + "_" + timeStamp + ".png");

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(path)
                    .setFullPage(true));

            System.out.println("Screenshot saved at: " + path.toAbsolutePath());
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