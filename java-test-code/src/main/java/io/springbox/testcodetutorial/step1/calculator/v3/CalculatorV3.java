package io.springbox.testcodetutorial.step1.calculator.v3;

import io.springbox.testcodetutorial.step1.calculator.Calculator;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotSupportedOperatorException;
import io.springbox.testcodetutorial.step1.calculator.v2.domain.PositiveOperand;
import io.springbox.testcodetutorial.step1.calculator.v3.strategy.Addition;
import io.springbox.testcodetutorial.step1.calculator.v3.strategy.Divide;
import io.springbox.testcodetutorial.step1.calculator.v3.strategy.Minus;
import io.springbox.testcodetutorial.step1.calculator.v3.strategy.Multiplication;
import io.springbox.testcodetutorial.step1.calculator.v3.strategy.Operator;
import java.util.List;

public class CalculatorV3 implements Calculator {

    private final List<Operator> operators = List.of(new Addition(), new Divide(), new Minus(), new Multiplication());

    @Override
    public int calculate(int firstOperand, String operator, int secondOperand) {
        PositiveOperand firstPositiveOperand = PositiveOperand.from(firstOperand);
        PositiveOperand secondPositiveOperand = PositiveOperand.from(secondOperand);

        return operators.stream()
            .filter(o -> o.isSupport(operator))
            .map(o -> o.operate(firstPositiveOperand, secondPositiveOperand))
            .findFirst()
            .orElseThrow(() -> new NotSupportedOperatorException(operator));
    }

}
