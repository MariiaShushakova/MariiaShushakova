package hw6.enums;

public enum Texts {
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

    public String getValue() {
        return itemText;
    }
}
