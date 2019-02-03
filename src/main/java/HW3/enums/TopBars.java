package HW3.enums;

public enum TopBars {
    topbarHOME("HOME"),
    topbarCONTACT("CONTACT FORM"),
    topbarSERVICE("SERVICE"),
    topbarMETALS("METALS & COLORS");

    public final String value;

    TopBars(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
