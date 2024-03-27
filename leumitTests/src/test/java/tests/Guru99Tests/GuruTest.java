package tests.Guru99Tests;

import Leumit.auto.TestPropsReader;
import Leumit.tests.PageEnums.GuruHeadersEnum;
import Leumit.tests.PageEnums.SeleniumHeaderOptionsEnum;
import Leumit.tests.PageObjects.LoginGuruPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class GuruTest extends BaseTests {

    private final String emailName = TestPropsReader.getProperty("guru.email.text");
    private final String expected = TestPropsReader.getProperty("guru.email.value");

    @Test(description = "Guru Test")
    public void GuruMenuTest() {
        loginGuruPage = new LoginGuruPage();
        homeGuruPage = loginGuruPage.loginToGuru(emailName);
        StringBuilder option = homeGuruPage.clickHeader(GuruHeadersEnum.SELENIUM.getValue(), SeleniumHeaderOptionsEnum.Table_Demo.getValue());
        Assert.assertEquals(option.toString(), expected, "Validate Guru headers options");
    }


}
