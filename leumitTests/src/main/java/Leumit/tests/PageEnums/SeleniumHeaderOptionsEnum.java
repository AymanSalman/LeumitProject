package Leumit.tests.PageEnums;

public enum SeleniumHeaderOptionsEnum {
    Flash_Movie_Demo("Flash Movie Demo"),
    Radio_Checkbox_Demo("Radio & Checkbox Demo"),
    Table_Demo("Table Demo"),
    Accessing_Link("Accessing Link"),
    Ajax_Demo("Ajax Demo"),
    Inside_Outside_Block_Level_Tag("Inside & Outside Block Level Tag"),
    Delete_Customer_Form("Delete Customer Form"),
    Yahoo("Yahoo"),
    Tooltip("Tooltip");

    private final String value;

    SeleniumHeaderOptionsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
