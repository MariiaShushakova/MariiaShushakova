package hw6.enums;

public enum TableNames {
    ROMAN("Roman"),
    SERGEY_IVAN("Sergey Ivan"),
    VLADZIMIR("Vladzimir"),
    HELEN_BENNETT("Helen Bennett"),
    YOSHI_TANNAMURI("Yoshi Tannamuri"),
    GIOVANNI_ROVELLI("Giovanni Rovelli");

    private String value;

    TableNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
