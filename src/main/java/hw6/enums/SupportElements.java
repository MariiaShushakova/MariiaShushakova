package hw6.enums;

// DifferentElements page Support Elements
public enum SupportElements {
    CHECKBOX_WATER("Water"),
    CHECKBOX_EARTH("Earth"),
    CHECKBOX_FIRE("Fire"),
    CHECKBOX_WIND("Wind"),

    RADIO_BUTTON_GOLD("Gold"),
    RADIO_BUTTON_SILVER("Silver"),
    RADIO_BUTTON_BRONZE("Bronze"),
    RADIO_BUTTON_SELEN("Selen"),

    DROPDOWN_RED("Red"),
    DROPDOWN_GREEN("Green"),
    DROPDOWN_YELLOW("Yellow"),
    DROPDOWN_BLUE("Blue");

    private final String value;

    SupportElements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
