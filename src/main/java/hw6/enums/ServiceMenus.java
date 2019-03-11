package hw6.enums;

public enum ServiceMenus {
        SUPPORT("SUPPORT"),
        DATES("DATES"),
        COMPLEX_TABLE("COMPLEX TABLE"),
        SIMPLE_TABLE("SIMPLE TABLE"),
        USER_TABLE("USER TABLE"),
        TABLE_WITH_PAGES("TABLE WITH PAGES"),
        DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

        private final String value;

        ServiceMenus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}
