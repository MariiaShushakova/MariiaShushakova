package hw6.enums;

public enum Strings {
    LINK_CLICKED(" link clicked");

    private final String value;

    Strings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}