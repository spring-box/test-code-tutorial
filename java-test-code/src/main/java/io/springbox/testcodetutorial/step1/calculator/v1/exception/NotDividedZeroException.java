package io.springbox.testcodetutorial.step1.calculator.v1.exception;

public class NotDividedZeroException extends RuntimeException {

    private static final String ERROR_MESSAGE = "0으로 나눌 수 없습니다.";

    public NotDividedZeroException() {
        super(ERROR_MESSAGE);
    }

}
