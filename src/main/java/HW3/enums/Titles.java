package HW3.enums;

public enum Titles {
    // TODO Please try to lead enum as described in Java code Convention
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
