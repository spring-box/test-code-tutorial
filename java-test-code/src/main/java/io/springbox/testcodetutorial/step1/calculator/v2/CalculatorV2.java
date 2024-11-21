package io.springbox.testcodetutorial.step1.calculator.v2;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateDivisor;

import io.springbox.testcodetutorial.step1.calculator.Calculator;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotSupportedOperatorException;
import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;

public class CalculatorV2 implements Calculator {

    public int calculate(int firstOperand, String operator, int secondOperand) {
        int firstPositiveOperand = PositiveOperand.from(firstOperand).value();
        int secondPositiveOperand = PositiveOperand.from(secondOperand).value();

        if ("+".equals(operator)) {
            return firstPositiveOperand + secondPositiveOperand;
        } else if ("-".equals(operator)) {
            return firstPositiveOperand - secondPositiveOperand;
        } else if ("*".equals(operator)) {
            return firstPositiveOperand * secondPositiveOperand;
        } else if ("/".equals(operator)) {
            validateDivisor(secondPositiveOperand);
            return firstPositiveOperand / secondPositiveOperand;
        } else {
            throw new NotSupportedOperatorException(operator);
        }
    }

}
