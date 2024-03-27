package Leumit.tests.PageObjects;

import Leumit.auto.LogManager;
import dev.failsafe.internal.util.Assert;
import leumit.auto.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class HomeGuruPage extends BasePage {


    public WebDriver driver;
    @FindBy(css = "table h2")
    private WebElement homePage;

    @FindBy(css = "ul.nav.navbar-nav > li")
    private List<WebElement> headersElements;

    public HomeGuruPage() {
        Assert.isTrue(isDisplayed(), "Guru Home Page loaded");
    }

    // First option to solve the first method
    public StringBuilder clickHeader(String[] headerNames) {
        LogManager.info("Clicking on header option '" + headerNames[0] + "'");
        StringBuilder headerOptionList = new StringBuilder();
        for (WebElement headersElement : headersElements) {
            String actualValue = headersElement.getText().trim();
            if (actualValue.equals(headerNames[0])) {
                DriverUtils.click(driver, headersElement);
                headerOptionList.append(actualValue);
            } else continue;
            if (headerNames.length > 1) {
                LogManager.info("Click on Guru header '" + headerNames[0] + "' option -> '" + headerNames[1] + "'");
                try {
                    List<WebElement> optionList = headersElement.findElements(By.cssSelector("li"));
                    DriverUtils.waitForElementSize(optionList, 5);
                    for (WebElement option : optionList) {
                        actualValue = option.getText().trim();
                        if (option.getText().trim().equals(headerNames[1])) {
                            headerOptionList.append(";").append(actualValue);
                            DriverUtils.click(driver, option);
                            return headerOptionList;
                        }
                    }
                } catch (Exception exception) {
                    LogManager.error("Guru Sub header option '" + headerNames[1] + "' NOT Exist");
                }
            }
            return headerOptionList;
        }
        LogManager.error("Guru header name '" + headerNames[0] + "' NOT Exist");
        return null;
    }


    // Second option to solve the first method
    public StringBuilder clickFooter(String[] footerOptions) {
        LogManager.info("Clicking on footer options");
        StringBuilder footerOptionList = new StringBuilder();
        for (String option : footerOptions) {
            try {
                WebElement footerElement = driver.findElement(By.xpath
                        ("//div[@id='navbar-brand-centered']/ul/li/a[contains(text(), '" + option + "')]"));
                DriverUtils.click(driver, footerElement);
                footerOptionList.append(option).append(";");
                if (footerOptions.length > 1) {
                    List<WebElement> subOptionList;
                    try {
                        subOptionList = footerElement.findElements(By.tagName("li"));
                    } catch (NoSuchElementException e) {
                        LogManager.error("No sub-options found for the footer header '" + option + "'.");
                        continue;
                    }
                    if (!subOptionList.isEmpty()) {
                        for (WebElement subOption : subOptionList) {
                            if (subOption.getText().trim().equals(footerOptions[1])) {
                                footerOptionList.append(subOption.getText());
                                DriverUtils.click(driver, subOption);
                                break;
                            }
                        }
                    } else {
                        LogManager.error("No sub-options found for the footer header '" + option + "'.");
                    }
                }
            } catch (NoSuchElementException e) {
                LogManager.error("Footer element for option '" + option + "' NOT found.");
            }
        }
        return footerOptionList;
    }

    // Second method
    public StringBuilder clickHeader(String headerName, String headerOption) {
        return clickHeader(new String[]{headerName, headerOption});
    }


    //-------------------------- Constructor methods ----------------//

    public boolean isDisplayed() {
        LogManager.info("Check if home Page is displayed");
        return homePage.isDisplayed();
    }
}
