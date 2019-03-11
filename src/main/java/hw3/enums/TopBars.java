package hw3.enums;

public enum TopBars {
    // TODO Please try to lead enum as described in Java code Convention - fixed
    TOPBAR_HOME("HOME"),
    TOPBAR_CONTACT("CONTACT FORM"),
    TOPBAR_SERVICE("SERVICE"),
    TOPBAR_METALS("METALS & COLORS");

    private final String value;

    TopBars(String value) {
        this.value = value;
    }

    // TODO Is this getter required here?
    public String getValue() {
        return value;
    }
}
