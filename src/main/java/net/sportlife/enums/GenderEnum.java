package net.sportlife.enums;

public enum  GenderEnum {

    MALE("MALE"),
    FEMALE("FEMALE");

    private String paramName;

    GenderEnum(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
