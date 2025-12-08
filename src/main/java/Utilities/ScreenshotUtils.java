package Utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";
        File destination = new File(path);
        try {
            FileHandler.copy(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;  // return path to attach in report
    }
}
