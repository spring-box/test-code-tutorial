package io.springbox.testcodetutorial.step1.calculator.v3.strategy;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateDivisor;

import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;

public class Divide implements Operator {

    private static final String DIVIDE_OPERATOR = "/";

    @Override
    public boolean isSupport(String operator) {
        return DIVIDE_OPERATOR.equals(operator);
    }

    @Override
    public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
        validateDivisor(secondOperand.value());
        return firstOperand.value() / secondOperand.value();
    }

}
