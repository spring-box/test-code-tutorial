package io.springbox.testcodetutorial.step1.calculator.v1;

import static io.springbox.testcodetutorial.step1.calculator.v1.validator.OperandValidator.validateDivisor;
import static io.springbox.testcodetutorial.step1.calculator.v1.validator.OperandValidator.validateOperandIsPositive;

import io.springbox.testcodetutorial.step1.calculator.v1.exception.NotSupportedOperatorException;

public class CalculatorV1 {

    public static int calculate(int firstOperand, String operator, int secondOperand) {
        validateOperandIsPositive(firstOperand, secondOperand);

        if ("+".equals(operator)) {
            return firstOperand + secondOperand;
        } else if ("-".equals(operator)) {
            return firstOperand - secondOperand;
        } else if ("*".equals(operator)) {
            return firstOperand * secondOperand;
        } else if ("/".equals(operator)) {
            validateDivisor(secondOperand);
            return firstOperand / secondOperand;
        } else {
            throw new NotSupportedOperatorException(operator);
        }
    }

}
