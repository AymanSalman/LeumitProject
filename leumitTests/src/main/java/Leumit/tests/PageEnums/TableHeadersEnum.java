package Leumit.tests.PageEnums;

public enum TableHeadersEnum {
    COMPANY("Company", 0),
    CONTACT("Contact", 1),
    COUNTRY("Country", 2);

    private final String value;
    private final int index;

    TableHeadersEnum(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public String getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

}
