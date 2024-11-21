package io.springbox.testcodetutorial.step1.calculator.v3.strategy;

import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;

public class Multiplication implements Operator {

    private static final String MULTIPLICATION_OPERATOR = "*";

    @Override
    public boolean isSupport(String operator) {
        return MULTIPLICATION_OPERATOR.equals(operator);
    }

    @Override
    public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
        return firstOperand.value() * secondOperand.value();
    }

}
