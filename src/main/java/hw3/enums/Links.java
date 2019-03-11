package hw3.enums;

public enum Links {
    // TODO Please try to lead enum as described in Java code Convention - fixed
    HP_LINK("https://epam.github.io/JDI/index.html"),
    HP_JDI("https://github.com/epam/JDI"),
    HP_LINK_TAG("a");

    private final String value;

    Links(String value) {
        this.value = value;
    }

    // TODO Is this getter required here? - Could you please tell me more appropriate way to get a value of
    // enum element?
    public String getValue() {
        return value;
    }
}
