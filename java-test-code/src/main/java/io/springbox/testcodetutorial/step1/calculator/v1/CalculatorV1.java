package io.springbox.testcodetutorial.step1.calculator.v1;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateDivisor;
import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateOperandIsPositive;

import io.springbox.testcodetutorial.step1.calculator.Calculator;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotSupportedOperatorException;

public class CalculatorV1 implements Calculator {

    public int calculate(int firstOperand, String operator, int secondOperand) {
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
