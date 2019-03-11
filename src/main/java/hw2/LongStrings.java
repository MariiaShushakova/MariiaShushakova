package hw2;

public enum LongStrings {
    BENEFIT_TEXT1("To include good practices\n"
            + "and ideas from successful\n" + "EPAM project"),
    BENEFIT_TEXT2("To be flexible and\n" + "customizable"),
    BENEFIT_TEXT3("To be multiplatform"),
    BENEFIT_TEXT4("Already have good base\n" + "(about 20 internal and\n"
                          + "some external projects),\n" + "wish to get more…"),
    LOREM_IPSUM("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
            " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD" +
            " EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN" +
            " REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    private final String value;

    LongStrings(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
