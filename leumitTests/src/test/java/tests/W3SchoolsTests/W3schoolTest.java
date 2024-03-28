package tests.W3SchoolsTests;

import Leumit.auto.TestPropsReader;
import Leumit.tests.PageEnums.TableCountryColumnEnum;
import Leumit.tests.PageEnums.TableHeadersEnum;
import Leumit.tests.PageObjects.W3SchoolsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class W3schoolTest extends BaseTests {

    private final String islandTradingCompany = TestPropsReader.getProperty("w3School.Company.table.island.trading.text");
    private String actualValue;

    @Test(description = "W3school Test 1")
    public void W3SchoolsCheckFirstMethodTests() {
        w3SchoolsPage = new W3SchoolsPage();
        actualValue = w3SchoolsPage.getTableCellText(TableHeadersEnum.COMPANY, islandTradingCompany, TableHeadersEnum.COUNTRY);
        Assert.assertEquals(actualValue, TableCountryColumnEnum.UK.getValue(), "The Country value for company name '"
                + islandTradingCompany + "'founded");
        w3SchoolsPage.verifyTableCellText(TableHeadersEnum.COMPANY, islandTradingCompany, TableHeadersEnum.COUNTRY, TableCountryColumnEnum.UK);
    }

    @Test(description = "W3school Test 2")
    public void W3SchoolsCheckSecondMethodTests() {
        w3SchoolsPage = new W3SchoolsPage();
        actualValue = w3SchoolsPage.getTableCellTextByXpath(islandTradingCompany, TableHeadersEnum.COUNTRY);
        Assert.assertEquals(actualValue, TableCountryColumnEnum.UK.getValue(), "The Country value for company name '"
                + islandTradingCompany + "'founded");
    }

}
