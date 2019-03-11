package hw3.enums;

public enum Texts {
    // TODO Please try to lead enum as described in Java code Convention - fixed
    TEXT_PRACTICE("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    TEXT_CUSTOM("To be flexible and\n" +
            "customizable"),
    TEXT_MULTI("To be multiplatform"),
    TEXT_BASE("Already have good base\n" +
            "(about 20 internal and\nsome external projects),\n" +
            "wish to get more…");

    private final String itemText;

    Texts(String iconText) {
        this.itemText = iconText;

    }

    // TODO Please try to lead enum as described in Java code Convention
    public String getValue() {
        return itemText;
    }
}
