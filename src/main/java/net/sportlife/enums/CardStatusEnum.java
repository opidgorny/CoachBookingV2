package net.sportlife.enums;

public enum CardStatusEnum {

    PREMIUM("PREMIUM"),
    CLASSIC("CLASSIC"),
    CLASSIC_PULL("CLASSIC_PULL"),
    CLASSIC_MORNING("CLASSIC_MORNING");

    private String paramName;

    CardStatusEnum(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
