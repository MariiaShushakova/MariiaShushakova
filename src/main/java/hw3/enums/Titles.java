package hw3.enums;

public enum Titles {
    // TODO Please try to lead enum as described in Java code Convention - fixed
    HP_TITLE("Home Page"),
    JDI_TITLE("JDI GITHUB");

    private final String value;

    Titles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
