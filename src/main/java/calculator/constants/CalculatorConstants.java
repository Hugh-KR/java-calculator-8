package calculator.constants;

/**
 * 계산기 애플리케이션의 모든 상수를 관리하는 enum.
 */
public enum CalculatorConstants {

    // 구분자 관련
    DEFAULT_DELIMITER("[,:]"),
    CUSTOM_DELIMITER_PREFIX("//"),
    CUSTOM_DELIMITER_PATTERN("//(.)\n(.*)"),
    NEWLINE_ESCAPE("\\n"),
    NEWLINE_ACTUAL("\n"),
    NEGATIVE_SIGN("-"),

    // 기본값
    DEFAULT_EMPTY_RESULT("0"),

    // 정규식 그룹 인덱스
    CUSTOM_DELIMITER_GROUP_INDEX("1"),
    CUSTOM_NUMBERS_GROUP_INDEX("2"),

    // 사용자 메시지
    INPUT_PROMPT("덧셈할 문자열을 입력해 주세요."),
    RESULT_PREFIX("결과 : "),

    // 오류 메시지
    ERROR_NULL_INPUT("입력값이 null입니다."),
    ERROR_NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    ERROR_INVALID_CUSTOM_DELIMITER("잘못된 커스텀 구분자 형식입니다."),
    ERROR_INVALID_NUMBER("숫자가 아닌 값이 포함되어 있습니다: "),
    ERROR_UNKNOWN("알 수 없는 오류");

    private final String value;

    CalculatorConstants(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }

    // 디미터 법칙 개선: 자주 사용되는 값들을 직접 반환하는 메서드 제공
    public static String getDefaultDelimiter() {
        return DEFAULT_DELIMITER.value;
    }

    public static String getCustomDelimiterPrefix() {
        return CUSTOM_DELIMITER_PREFIX.value;
    }

    public static String getCustomDelimiterPattern() {
        return CUSTOM_DELIMITER_PATTERN.value;
    }

    public static String getNewlineEscape() {
        return NEWLINE_ESCAPE.value;
    }

    public static String getNewlineActual() {
        return NEWLINE_ACTUAL.value;
    }

    public static String getNegativeSign() {
        return NEGATIVE_SIGN.value;
    }

    public static int getDefaultEmptyResult() {
        return DEFAULT_EMPTY_RESULT.getIntValue();
    }

    public static String getInputPrompt() {
        return INPUT_PROMPT.value;
    }

    public static String getResultPrefix() {
        return RESULT_PREFIX.value;
    }

    public static String getErrorNullInput() {
        return ERROR_NULL_INPUT.value;
    }

    public static String getErrorNegativeNumber() {
        return ERROR_NEGATIVE_NUMBER.value;
    }

    public static String getErrorInvalidCustomDelimiter() {
        return ERROR_INVALID_CUSTOM_DELIMITER.value;
    }

    public static String getErrorInvalidNumber() {
        return ERROR_INVALID_NUMBER.value;
    }

    public static int getCustomDelimiterGroupIndex() {
        return CUSTOM_DELIMITER_GROUP_INDEX.getIntValue();
    }

    public static int getCustomNumbersGroupIndex() {
        return CUSTOM_NUMBERS_GROUP_INDEX.getIntValue();
    }

    @Override
    public String toString() {
        return value;
    }
}
