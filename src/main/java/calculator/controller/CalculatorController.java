package calculator.controller;

import calculator.model.Calculator;
import calculator.validation.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 계산기 애플리케이션의 컨트롤러 클래스. 사용자 입력을 받아 계산을 수행하고 결과를 출력합니다.
 */
public class CalculatorController {
    private final Calculator calculator;
    private final InputValidator inputValidator;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this(new Calculator(), new InputValidator(), new InputView(), new OutputView());
    }

    public CalculatorController(final Calculator calculator, final InputValidator inputValidator,
            final InputView inputView, final OutputView outputView) {
        this.calculator = calculator;
        this.inputValidator = inputValidator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 계산기 애플리케이션을 실행합니다. 사용자 입력을 받아 검증하고 계산한 후 결과를 출력합니다.
     *
     * @throws IllegalArgumentException 잘못된 입력이 제공된 경우
     */
    public void run() {
        final String input = inputView.readInput();
        inputValidator.validateAndThrow(input);

        final int result = calculator.calculate(input);
        outputView.printResult(result);
    }
}
