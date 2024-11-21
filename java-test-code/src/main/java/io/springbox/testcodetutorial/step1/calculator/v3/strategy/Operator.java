package io.springbox.testcodetutorial.step1.calculator.v3.strategy;

import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;

public interface Operator {

    boolean isSupport(String operator);

    int operate(PositiveOperand firstOperand, PositiveOperand secondOperand);

}
