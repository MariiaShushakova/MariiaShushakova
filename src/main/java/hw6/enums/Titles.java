package hw6.enums;

public enum Titles {
    HP_TITLE("Home Page"),
    UT_TITLE("User Table");

    private final String value;

    Titles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
