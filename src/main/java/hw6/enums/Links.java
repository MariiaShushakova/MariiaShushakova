package hw6.enums;

public enum Links {
    HP_LINK("https://epam.github.io/JDI/index.html");

    private final String value;

    Links(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
