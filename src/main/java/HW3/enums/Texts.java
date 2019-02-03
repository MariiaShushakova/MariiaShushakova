package HW3.enums;

public enum Texts {
    TextPRACTICE("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    TextCUSTOM("To be flexible and\n" +
            "customizable"),
    TextMULTI("To be multiplatform"),
    TextBASE("Already have good base\n" +
            "(about 20 internal and\nsome external projects),\n" +
            "wish to get more…");

    public final String itemText;

    Texts(String iconText) {
        this.itemText = iconText;

    }

    public String getValue() {
        return itemText;
    }
}
