package io.springbox.testcodetutorial.step1.calculator.common.exception;

public class IsNotPositiveOperandException extends RuntimeException {

    private static final String ERROR_MESSAGE = "피 연산자는 양수만 허용됩니다. [%s]";

    public IsNotPositiveOperandException(int operand) {
        super(ERROR_MESSAGE.formatted(operand));
    }

}
