package hw6.enums;

public enum Users {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
