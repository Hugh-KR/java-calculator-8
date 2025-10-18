package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(final String[] args) {
        final CalculatorController controller = new CalculatorController();
        controller.run();
    }
}
