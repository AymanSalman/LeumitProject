package Leumit.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class CaptureScreenshot {
    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + testName + ".png";
            Path destinationPath = Paths.get(screenshotPath);
            Files.createDirectories(destinationPath.getParent());
            FileHandler.copy(screenshotFile, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

