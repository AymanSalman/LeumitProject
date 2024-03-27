package leumit.auto;

import Leumit.auto.LogManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = new ExtentReports();
    private static final ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

    @Override
    public void onTestStart(ITestResult result) {
        LogManager.info("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogManager.info("Test '" + result.getName() + "' Success and finish running running");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String failedTest = result.getName();
        LogManager.error("Failed test name: " + failedTest);
        extent.attachReporter(reporter);
        extent.createTest(failedTest);
        extent.flush();
    }
}
