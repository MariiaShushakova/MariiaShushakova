package HW4.enums;

public enum ServiceMenu {
        SUPPORT("SUPPORT"),
        DATES("DATES"),
        COMPLEX_TABLE("COMPLEX TABLE"),
        SIMPLE_TABLE("SIMPLE TABLE"),
        TABLE_WITH_PAGES("TABLE WITH PAGES"),
        DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

        private final String value;

        ServiceMenu(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}
