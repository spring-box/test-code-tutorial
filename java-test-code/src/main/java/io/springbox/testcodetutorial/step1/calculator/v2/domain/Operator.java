package io.springbox.testcodetutorial.step1.calculator.v2.domain;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateDivisor;

import lombok.Getter;

@Getter
public enum Operator {

    ADDITIONAL("+") {
        @Override
        public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
            return firstOperand.value() + secondOperand.value();
        }
    },
    MINUS("-") {
        @Override
        public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
            return firstOperand.value() - secondOperand.value();
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
            return firstOperand.value() * secondOperand.value();
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(PositiveOperand firstOperand, PositiveOperand secondOperand) {
            validateDivisor(secondOperand.value());
            return firstOperand.value() / secondOperand.value();
        }
    };

    private final String operatorExpression;

    Operator(String operatorExpression) {
        this.operatorExpression = operatorExpression;
    }

    public abstract int operate(PositiveOperand firstOperand, PositiveOperand secondOperand);
}
