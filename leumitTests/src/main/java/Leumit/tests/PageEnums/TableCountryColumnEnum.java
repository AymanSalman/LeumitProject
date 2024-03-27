package Leumit.tests.PageEnums;

public enum TableCountryColumnEnum {
    GERMANY("Germany"),
    MEXICO("Mexico"),
    AUSTRIA("Austria"),
    UK("UK"),
    CANADA("Canada"),
    ITALY("Italy");

    private final String value;

    TableCountryColumnEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
