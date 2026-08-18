public enum SchemeType {
    NONE,
    STUDENT,
    WEEKEND;

    public static SchemeType fromString(String value) {
        return SchemeType.valueOf(value.toUpperCase());
    }
}
