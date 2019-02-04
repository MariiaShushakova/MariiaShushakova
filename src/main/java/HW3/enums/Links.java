package HW3.enums;

public enum Links {
    // TODO Please try to lead enum as described in Java code Convention
    HPLink("https://epam.github.io/JDI/index.html"),
    HPJDI("https://github.com/epam/JDI"),
    LinkTag("a");

    public final String value;

    Links(String value) {
        this.value = value;
    }

    // TODO Is this getter required here?
    public String getValue() {
        return value;
    }
}
