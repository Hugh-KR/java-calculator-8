package calculator.validation;

import calculator.constants.CalculatorConstants;

/**
 * 입력값 검증을 담당하는 클래스. 검증 로직과 결과 처리를 통합하여 관리합니다.
 */
public class InputValidator {

    private String lastErrorMessage;

    /**
     * 입력값의 유효성을 검증합니다.
     *
     * @param input 검증할 입력 문자열
     * @return 검증 성공 여부
     */
    public boolean validate(final String input) {
        if (isNull(input)) {
            return false;
        }

        if (isEmpty(input)) {
            return true;
        }

        if (containsNegativeNumber(input)) {
            return false;
        }

        clearErrorMessage();
        return true;
    }

    private boolean isNull(final String input) {
        if (input == null) {
            final String errorMessage = CalculatorConstants.getErrorNullInput();
            lastErrorMessage = errorMessage;
            return true;
        }
        return false;
    }

    private boolean isEmpty(final String input) {
        if (input.trim().isEmpty()) {
            clearErrorMessage();
            return true;
        }
        return false;
    }

    private boolean containsNegativeNumber(final String input) {
        final String negativeSign = CalculatorConstants.getNegativeSign();
        if (input.contains(negativeSign)) {
            final String errorMessage = CalculatorConstants.getErrorNegativeNumber();
            lastErrorMessage = errorMessage;
            return true;
        }
        return false;
    }

    private void clearErrorMessage() {
        lastErrorMessage = null;
    }

    /**
     * 입력값을 검증하고 실패 시 예외를 던집니다.
     *
     * @param input 검증할 입력 문자열
     * @throws IllegalArgumentException 검증이 실패한 경우
     */
    public void validateAndThrow(final String input) {
        if (!validate(input)) {
            throw new IllegalArgumentException(lastErrorMessage);
        }
    }

}
