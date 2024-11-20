package io.springbox.testcodetutorial.step1.calculator.common.exception;

public class NotSupportedOperatorException extends RuntimeException {

    private static final String ERROR_MESSAGE = "지원하지 않는 연산자입니다. [%s]";

    public NotSupportedOperatorException(String operator) {
        super(ERROR_MESSAGE.formatted(operator));
    }

}
