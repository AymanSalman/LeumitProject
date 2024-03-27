package Leumit.tests.PageObjects;

import Leumit.auto.LogManager;
import dev.failsafe.internal.util.Assert;
import leumit.auto.utils.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginGuruPage extends BasePage{

    @FindBy(css = ".barone")
    private WebElement guruLoginElement;

    @FindBy(name = "emailid")
    private WebElement emailInput;

    @FindBy(name = "btnLogin")
    private WebElement submitButton;

    public LoginGuruPage() {
        Assert.isTrue(isDisplayed(), "Guru Login Page loaded");
    }


    public HomeGuruPage loginToGuru(String emailAddress){
        LogManager.info("Login To Guru demo site using email : '" + emailAddress + "'");
        DriverUtils.waitingForElement(driver,emailInput,3);
        DriverUtils.setValue(driver,emailInput,emailAddress);
        DriverUtils.click(driver,submitButton);
        return new HomeGuruPage();
    }

    //-------------------------- Constructor methods ----------------//

    public boolean isDisplayed() {
        LogManager.info("Check if Guru Login Page is displayed");
        return guruLoginElement.isDisplayed();
    }
}
