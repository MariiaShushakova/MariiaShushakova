package base.JDI.enums;

public enum Navigation {
    HOME("Home"),
    CONTACT("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    private final String value;

    Navigation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
