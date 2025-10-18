package calculator.view;

import calculator.constants.CalculatorConstants;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력을 담당하는 뷰 클래스.
 */
public class InputView {

    /**
     * 사용자로부터 계산할 문자열을 입력받습니다.
     *
     * @return 사용자가 입력한 문자열
     */
    public String readInput() {
        final String inputPrompt = CalculatorConstants.getInputPrompt();
        System.out.println(inputPrompt);
        return Console.readLine();
    }
}
