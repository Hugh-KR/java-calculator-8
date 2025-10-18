package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.constants.CalculatorConstants;

/**
 * 문자열 덧셈 계산기 클래스. 쉼표, 콜론, 커스텀 구분자를 사용하여 숫자들의 합을 계산합니다.
 */
public class Calculator {

    /**
     * 입력된 문자열에서 숫자들을 추출하여 합계를 계산합니다.
     *
     * @param input 계산할 숫자들이 포함된 문자열
     * @return 숫자들의 합계
     * @throws IllegalArgumentException 잘못된 형식의 입력이거나 음수가 포함된 경우
     */
    public int calculate(final String input) {
        if (input == null || input.isEmpty()) {
            final int defaultEmptyResult = CalculatorConstants.getDefaultEmptyResult();
            return defaultEmptyResult;
        }

        String[] numbers = parseNumbers(input);
        return sumNumbers(numbers);
    }

    private String[] parseNumbers(final String input) {
        final String customDelimiterPrefix = CalculatorConstants.getCustomDelimiterPrefix();
        if (input.startsWith(customDelimiterPrefix)) {
            return parseWithCustomDelimiter(input);
        } else {
            final String defaultDelimiter = CalculatorConstants.getDefaultDelimiter();
            return input.split(defaultDelimiter);
        }
    }

    private String[] parseWithCustomDelimiter(final String input) {
        final String normalizedInput = normalizeNewlines(input);
        final Matcher matcher = createCustomDelimiterMatcher(normalizedInput);

        if (matcher.matches()) {
            return extractNumbersWithCustomDelimiter(matcher);
        }

        final String errorMessage = CalculatorConstants.getErrorInvalidCustomDelimiter();
        throw new IllegalArgumentException(errorMessage);
    }

    private String normalizeNewlines(final String input) {
        final String newlineEscape = CalculatorConstants.getNewlineEscape();
        final String newlineActual = CalculatorConstants.getNewlineActual();
        return input.replace(newlineEscape, newlineActual);
    }

    private Matcher createCustomDelimiterMatcher(final String input) {
        final String customDelimiterPattern = CalculatorConstants.getCustomDelimiterPattern();
        final Pattern pattern = Pattern.compile(customDelimiterPattern);
        return pattern.matcher(input);
    }

    private String[] extractNumbersWithCustomDelimiter(final Matcher matcher) {
        final int delimiterGroupIndex = CalculatorConstants.getCustomDelimiterGroupIndex();
        final int numbersGroupIndex = CalculatorConstants.getCustomNumbersGroupIndex();

        final String customDelimiter = matcher.group(delimiterGroupIndex);
        final String numbers = matcher.group(numbersGroupIndex);
        return numbers.split(Pattern.quote(customDelimiter));
    }

    private int sumNumbers(final String[] numbers) {
        return Arrays.stream(numbers).filter(this::isNotEmpty)
                .mapToInt(this::parseAndValidateNumber).sum();
    }

    private boolean isNotEmpty(final String number) {
        return !number.trim().isEmpty();
    }

    private int parseAndValidateNumber(final String number) {
        try {
            final int num = parseNumber(number);
            validateNonNegative(num);
            return num;
        } catch (NumberFormatException e) {
            final String errorMessage = CalculatorConstants.getErrorInvalidNumber() + number;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private int parseNumber(final String number) {
        return Integer.parseInt(number.trim());
    }

    private void validateNonNegative(final int num) {
        final int defaultEmptyResult = CalculatorConstants.getDefaultEmptyResult();
        if (num < defaultEmptyResult) {
            final String errorMessage = CalculatorConstants.getErrorNegativeNumber();
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
