package HW3.enums;

public enum Links {
    HPLink("https://epam.github.io/JDI/index.html"),
    HPJDI("https://github.com/epam/JDI"),
    LinkTag("a");

    public final String value;

    Links(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
