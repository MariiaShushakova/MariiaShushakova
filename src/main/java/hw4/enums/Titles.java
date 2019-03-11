package hw4.enums;

public enum Titles {
    HP_TITLE("Home Page");

    private final String value;

    Titles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
