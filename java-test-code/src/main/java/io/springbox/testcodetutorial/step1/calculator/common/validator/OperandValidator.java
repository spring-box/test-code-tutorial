package io.springbox.testcodetutorial.step1.calculator.common.validator;

import io.springbox.testcodetutorial.step1.calculator.common.exception.IsNotPositiveOperandException;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotDividedZeroException;
import java.util.Arrays;

public class OperandValidator {

    public static void validateOperandIsPositive(int... operands) {
        Arrays.stream(operands)
            .filter(OperandValidator::isNotPositive)
            .findFirst()
            .ifPresent(operand -> {
                throw new IsNotPositiveOperandException(operand);
            });
    }

    private static boolean isNotPositive(int operand) {
        return operand < 0;
    }

    public static void validateDivisor(int secondOperand) {
        if (isZero(secondOperand)) {
            throw new NotDividedZeroException();
        }
    }

    private static boolean isZero(int divisor) {
        return divisor == 0;
    }

}
