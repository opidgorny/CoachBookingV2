package net.sportlife.enums;

public enum RoleStatusEnum {

    ROLE_ADMIN("ADMIN"),
    ROLE_COACH("COACH"),
    ROLE_USER("USER");

    private String paramName;

    RoleStatusEnum(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
