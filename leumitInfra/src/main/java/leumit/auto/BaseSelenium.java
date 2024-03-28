package leumit.auto;

import Leumit.auto.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import static leumit.auto.SeleniumDriver.createDriver;

public class BaseSelenium {

    public static WebDriver driver;

    @BeforeClass
    protected WebDriver initEnvironment() {
        System.out.println("<------- Start Running browser Chrome browserType ------->");
        driver = createDriver();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    protected void afterSuiteActions() throws IOException {
        close(driver);
        killBrowser();
    }

    public void initAllElements(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 8), this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    public void close(WebDriver driver) {
        try {
            driver.quit();
        } catch (Exception e) {
            LogManager.info("Failed to close driver");
        }
    }

    public void killBrowser() throws IOException {
        LogManager.info("kill chrome driver");
        Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
    }

}
