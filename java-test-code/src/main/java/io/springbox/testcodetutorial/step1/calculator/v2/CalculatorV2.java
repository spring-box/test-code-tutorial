package io.springbox.testcodetutorial.step1.calculator.v2;

import io.springbox.testcodetutorial.step1.calculator.Calculator;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotSupportedOperatorException;
import io.springbox.testcodetutorial.step1.calculator.v2.domain.Operator;
import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;
import java.util.Arrays;

public class CalculatorV2 implements Calculator {

    public int calculate(int firstOperand, String operator, int secondOperand) {
        int firstPositiveOperand = PositiveOperand.from(firstOperand).value();
        int secondPositiveOperand = PositiveOperand.from(secondOperand).value();

        return Arrays.stream(Operator.values())
            .filter(o -> o.getOperatorExpression().equals(operator))
            .map(o -> o.operate(firstPositiveOperand, secondPositiveOperand))
            .findFirst()
            .orElseThrow(() -> new NotSupportedOperatorException(operator));
    }

}
