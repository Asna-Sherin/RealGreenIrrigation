package Frontendtest;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import Utilities.ScreenshotUtils;
import base.BaseClass;   // Your driver

public class TestListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();
        String screenshotPath = ScreenshotUtils.takeScreenshot(driver,testName);

        Reporter.log("Test Failed - Screenshot attached: " + screenshotPath);
        Reporter.log("<a href='" + screenshotPath + "'>Click to view Screenshot</a>");
        Reporter.log("<br><br><img src='" + screenshotPath + "' height='300' width='300'/><br>");
    }
}

