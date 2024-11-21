package io.springbox.testcodetutorial.step1.calculator.v2.domain;

import static io.springbox.testcodetutorial.step1.calculator.common.validator.OperandValidator.validateDivisor;

import lombok.Getter;

@Getter
public enum Operator {

    ADDITIONAL("+") {
        @Override
        public int operate(int firstOperand, int secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS("-") {
        @Override
        public int operate(int firstOperand, int secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operate(int firstOperand, int secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int firstOperand, int secondOperand) {
            validateDivisor(secondOperand);
            return firstOperand / secondOperand;
        }
    };

    private final String operatorExpression;

    Operator(String operatorExpression) {
        this.operatorExpression = operatorExpression;
    }

    public abstract int operate(int firstOperand, int secondOperand);
}
