package io.springbox.testcodetutorial.step1.calculator.v1;

import io.springbox.testcodetutorial.step1.calculator.v1.exception.NotDividedZeroException;

public class CalculatorV1 {

    public static int calculate(int firstOperand, String operator, int secondOperand) {
        if ("+".equals(operator)) {
            return firstOperand + secondOperand;
        } else if ("-".equals(operator)) {
            return firstOperand - secondOperand;
        } else if ("*".equals(operator)) {
            return firstOperand * secondOperand;
        } else if ("/".equals(operator)) {
            if (secondOperand == 0) {
                throw new NotDividedZeroException();
            }
            return firstOperand / secondOperand;
        }
        return 0;
    }

}
