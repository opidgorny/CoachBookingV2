package net.sportlife.enums;

public enum CoachStatusEnum {

    AVAILABLE("AVAILABLE"),
    BUSY("BUSY"),
    ABSENT("OUT_OF_WORK");

    private String paramName;

    CoachStatusEnum(String paramName) { this.paramName = paramName; }

    public String getParamName() {
        return paramName;
    }

}
