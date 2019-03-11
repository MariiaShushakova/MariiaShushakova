package hw6.enums;

public enum TextHeaders {
    TEXT_HEADER_1("EPAM FRAMEWORK WISHES…"),
    TEXT_HEADER_2("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR" +
            " INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD" +
            " EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR" +
            " IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    private final String header;

    TextHeaders(String header) {
        this.header = header;
    }

    public String getValue() {
        return header;
    }
}
