package springdemo.model;

public enum Authorities {
    ROLE_MANAGER("manager"),
    ROLE_EMPLOYEE("employee"),
    ROLE_ADMIN("admin");

    String values;

    Authorities(String values) {
        this.values = values;
    }

    public String getValues() {
        return values;
    }
}
