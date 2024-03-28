package leumit.auto;

import Leumit.auto.CaptureScreenshot;
import Leumit.auto.ExtentManager;
import Leumit.auto.LogManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static leumit.auto.BaseSelenium.driver;

public class TestListener implements ITestListener {

    public static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest("Starting test: " + result.getName()).assignCategory(ITestListener.class.getName());
        LogManager.setExtentTest(test);
        LogManager.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test '" + result.getName() + "' Success and finish running");
        LogManager.info("Test '" + result.getName() + "' Success and finish running");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test name: '" + result.getName() + "' have been FAILED !!!!!");
        LogManager.error("Failed test name: " + result.getName());
        String screenshotPath = CaptureScreenshot.captureScreenshot(driver, result.getName());
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
