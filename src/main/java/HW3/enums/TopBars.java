package HW3.enums;

public enum TopBars {
    // TODO Please try to lead enum as described in Java code Convention
    topbarHOME("HOME"),
    topbarCONTACT("CONTACT FORM"),
    topbarSERVICE("SERVICE"),
    topbarMETALS("METALS & COLORS");

    public final String value;

    TopBars(String value) {
        this.value = value;
    }

    // TODO Is this getter required here?
    public String getValue() {
        return value;
    }
}
