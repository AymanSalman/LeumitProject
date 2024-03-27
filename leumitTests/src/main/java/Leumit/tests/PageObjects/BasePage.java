package Leumit.tests.PageObjects;

import leumit.auto.BaseSelenium;

public class BasePage extends BaseSelenium {

    BasePage() {
        driver = getDriver();
        initAllElements(driver);
    }
}
