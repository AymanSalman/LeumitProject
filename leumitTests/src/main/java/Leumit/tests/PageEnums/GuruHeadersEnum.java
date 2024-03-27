package Leumit.tests.PageEnums;

import org.openqa.selenium.By;

public enum GuruHeadersEnum {
    SELENIUM("Selenium"),
    INSURANCE_PROJECT("Insurance Project"),
    AGILE_PROJECT("Agile Project"),
    BANK_PROJECT("Bank Project"),
    SECURITY_PROJECT("Security Project"),
    TELECOM_PROJECT("Telecom Project"),
    PAYMENT_GATEWAY_PROJECT("Payment Gateway Project"),
    NEW_TOURS("New Tours"),
    SEO("SEO");

    private final String value;

    GuruHeadersEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
