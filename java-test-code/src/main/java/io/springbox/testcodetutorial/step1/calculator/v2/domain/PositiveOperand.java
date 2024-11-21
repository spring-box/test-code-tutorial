package io.springbox.testcodetutorial.step1.calculator.v2.domain;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateOperandIsPositive;

public record PositiveOperand(
    int value
) {

    public static PositiveOperand from(int operand) {
        validateOperandIsPositive(operand);
        return new PositiveOperand(operand);
    }

}
