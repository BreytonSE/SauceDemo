package com.saucedemo.utilities;

public class AllureReportUtil {

    public static void generateAllureReport(){
        try{
            ProcessBuilder builder = new ProcessBuilder("mvn", "allure:report");
            builder.inheritIO();

            Process process = builder.start();
            process.waitFor();

            if(process.exitValue() == 0){
                System.out.println("Allure Report Generated");
            }else {
                System.out.println("Allure Report Failed");
            }
        }catch (Exception e){
            System.err.println("Report generation failed: " + e.getMessage());
        }
    }
}
