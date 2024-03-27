package Leumit.tests.PageObjects;

import Leumit.auto.LogManager;
import Leumit.tests.PageEnums.TableCountryColumnEnum;
import Leumit.tests.PageEnums.TableHeadersEnum;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class W3SchoolsPage extends BasePage {

    private int columnIndex;

    @FindBy(css = "#main h1")
    WebElement tablesPage;

    @FindBy(id = "customers")
    WebElement tableElement;
    @FindBy(css = "[id='customers'] tr")
    List<WebElement> tableRowsElements;

    public W3SchoolsPage() {
        Assert.isTrue(isDisplayed(), "Validate W3School 'HTML Tables' page is displayed");
    }

    public String getTableCellText(TableHeadersEnum headerTarget, String searchText, TableHeadersEnum w3shooolTableHeadersEnum) {
        LogManager.info("Get table value from header name '" + w3shooolTableHeadersEnum.getValue()
                + "' where company name is " + searchText);
        for (int i = 1; i < tableRowsElements.size(); i++) {
            List<WebElement> cells = tableRowsElements.get(i).findElements(By.tagName("td"));
            if (!cells.isEmpty() && cells.get(headerTarget.getIndex()).getText().trim().equals(searchText)) {
                columnIndex = getColumnIndex(w3shooolTableHeadersEnum);
                if (columnIndex != -1) {
                    return cells.get(columnIndex).getText().trim();
                } else {
                    LogManager.error("Invalid column index: " + columnIndex);
                    return null;
                }
            }
        }
        LogManager.error("Company '" + w3shooolTableHeadersEnum.getValue() + "' not found in the table");
        return null;
    }

    public String getTableCellTextByXpath(String searchText, TableHeadersEnum w3shooolTableHeadersEnum)
            throws NoSuchElementException {
        LogManager.info("Get table value from header name '" + w3shooolTableHeadersEnum.getValue()
                + "' where company name is '" + searchText + "' BY XPATH");
        try {
            columnIndex = getColumnIndex(w3shooolTableHeadersEnum) + 1;
            String xpathExpression = "//td[contains(text(),'" + searchText + "')]/../td[" + columnIndex + "]";
            WebElement cell = tableElement.findElement(By.xpath(xpathExpression));
            return cell.getText();
        } catch (NoSuchElementException e) {
            LogManager.error("Failed to find the table cell by searched text '" + searchText
                    + "', and column header name '" + w3shooolTableHeadersEnum.getValue() + "'");
            return null;
        }
    }

    //-------------------------- Verify methods --------------------//

    public void verifyTableCellText(TableHeadersEnum headerTarget, String searchText, TableHeadersEnum w3shooolTableHeadersEnum
            , TableCountryColumnEnum tableCountryColumnEnum) {
        LogManager.info("Verify table value from header name '" + w3shooolTableHeadersEnum.getValue()
                + "' where company name is '" + searchText + "', equals to " + tableCountryColumnEnum.getValue());
        String actualValue = getTableCellText(headerTarget, searchText, w3shooolTableHeadersEnum);
        org.testng.Assert.assertEquals(actualValue, tableCountryColumnEnum.getValue()
                , "Verify searchedText '" + searchText + "', Equals to '" + tableCountryColumnEnum.getValue() + "'");
    }


    //-------------------------- private methods --------------------//

    private int getColumnIndex(TableHeadersEnum w3shooolTableHeadersEnum) {
        LogManager.info("Get Column Index in W3School 'HTML Tables' page");
        int columnIndex;
        switch (w3shooolTableHeadersEnum.getValue()) {
            case "Company":
                columnIndex = 0;
                break;
            case "Contact":
                columnIndex = 1;
                break;
            case "Country":
                columnIndex = 2;
                break;
            default:
                LogManager.error("Invalid column name: " + w3shooolTableHeadersEnum.getValue());
                columnIndex = -1;
        }
        return columnIndex;
    }

    //-------------------------- Constructor methods ----------------//

    public boolean isDisplayed() {
        LogManager.info("Check if W3School 'HTML Tables' page is displayed");
        return tablesPage.isDisplayed();
    }

}
