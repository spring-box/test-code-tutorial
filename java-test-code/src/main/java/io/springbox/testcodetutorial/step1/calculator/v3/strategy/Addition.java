package io.springbox.testcodetutorial.step1.calculator.v3.strategy;

import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;

public class Addition implements Operator {

    private static final String ADDITION_OPERATOR = "+";

    @Override
    public boolean isSupport(String operator) {
        return ADDITION_OPERATOR.equals(operator);
    }

    @Override
    public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
        return firstOperand.value() + secondOperand.value();
    }

}
