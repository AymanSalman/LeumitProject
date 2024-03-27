package leumit.auto.utils;

import Leumit.auto.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverUtils {

    public static void waitingForElement(WebDriver driver, WebElement element, int waitingTime) {
        LogManager.debug("Waiting For Element - " + element.getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LogManager.error("Element '" + element + "' NOT visible after waiting 5 seconds");
        }
    }

    public static void waitForElementSize(List<WebElement> elements, int timeoutInSeconds) {
        LogManager.debug("Waiting For Elements size - " + elements);
        while (timeoutInSeconds > 0) {
            if (!elements.isEmpty())
                return;
            try {
                Thread.sleep(500);
                timeoutInSeconds--;
            } catch (InterruptedException e) {
                LogManager.debug("Retry get elements size");
            }
        }
        LogManager.debug("Elements '" + elements + "' list NOT found within the timeout" + timeoutInSeconds);
    }

    public static void click(WebDriver driver, WebElement element) {
        LogManager.debug("Click on: " + element);
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            LogManager.debug("Try and click on element using Javascript: " + element);
            waitUntilClickable(driver, element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception ex) {
            LogManager.error("Failed to click on element - " + element);
        }
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element) {
        LogManager.debug("Wait For element to be clickable, element : " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void setValue(WebDriver driver, WebElement element, String value) {
        LogManager.debug("Set value - " + value);
        try {
            element.sendKeys(value);
        } catch (NoSuchElementException satValueException) {
            DriverUtils.waitingForElement(driver, element, 5);
            element.sendKeys(value);
        } catch (Exception setValueError) {
            LogManager.warn("Set Value - Error:" + setValueError.getMessage());
        }
    }

}
