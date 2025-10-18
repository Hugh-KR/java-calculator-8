package calculator.view;

import calculator.constants.CalculatorConstants;

/**
 * 계산 결과 출력을 담당하는 뷰 클래스.
 */
public class OutputView {

    /**
     * 계산 결과를 출력합니다.
     *
     * @param result 출력할 계산 결과
     */
    public void printResult(final int result) {
        final String resultPrefix = CalculatorConstants.getResultPrefix();
        System.out.println(resultPrefix + result);
    }
}
