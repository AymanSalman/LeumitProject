package leumit.auto;

import Leumit.auto.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {
    private static final String site = System.getProperty("siteDomain");
    private static final String extension = System.getProperty("extension");

    public static WebDriver createDriver() {
        WebDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver", "C:/automationsProjects/LeumitProject/leumitInfra/src/main/resources/lib/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://" + site + "/" + extension);
        } catch (Throwable driverError) {
            LogManager.error("init web driver Error: " + driverError.getMessage());
        }
        return driver;
    }
}
