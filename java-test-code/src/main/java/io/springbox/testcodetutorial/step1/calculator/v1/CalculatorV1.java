package io.springbox.testcodetutorial.step1.calculator.v1;

import io.springbox.testcodetutorial.step1.calculator.v1.exception.IsNotPositiveOperandException;
import io.springbox.testcodetutorial.step1.calculator.v1.exception.NotDividedZeroException;

public class CalculatorV1 {

    public static int calculate(int firstOperand, String operator, int secondOperand) {
        validateOperandIsPositive(firstOperand, secondOperand);

        if ("+".equals(operator)) {
            return firstOperand + secondOperand;
        } else if ("-".equals(operator)) {
            return firstOperand - secondOperand;
        } else if ("*".equals(operator)) {
            return firstOperand * secondOperand;
        } else if ("/".equals(operator)) {
            validateDivisor(secondOperand);
            return firstOperand / secondOperand;
        }
        return 0;
    }

    private static void validateOperandIsPositive(int firstOperand, int secondOperand) {
        if (firstOperand < 0) {
            throw new IsNotPositiveOperandException(firstOperand);
        }

        if (secondOperand < 0) {
            throw new IsNotPositiveOperandException(firstOperand);
        }
    }
    
    private static void validateDivisor(int secondOperand) {
        if (isZero(secondOperand)) {
            throw new NotDividedZeroException();
        }
    }

    private static boolean isZero(int divisor) {
        return divisor == 0;
    }

}
