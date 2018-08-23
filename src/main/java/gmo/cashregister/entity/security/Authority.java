package gmo.cashregister.entity.security;

public enum Authority {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private String name;

    Authority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
