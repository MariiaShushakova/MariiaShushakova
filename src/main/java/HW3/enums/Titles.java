package HW3.enums;

public enum Titles {
    HPTitle("Home Page"),
    JDITitle("JDI GITHUB");

    private final String value;

    Titles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
