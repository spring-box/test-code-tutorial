package io.springbox.testcodetutorial.step1.calculator.v1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("V1:사칙 연산 계산기")
class CalculatorV1Test {

    private static Stream<Arguments> calculate() {
        final int firstOperand = 6;
        final int secondOperand = 3;

        return Stream.of(
            Arguments.of(firstOperand, "+", secondOperand, firstOperand + secondOperand),
            Arguments.of(firstOperand, "-", secondOperand, firstOperand - secondOperand),
            Arguments.of(firstOperand, "*", secondOperand, firstOperand * secondOperand),
            Arguments.of(firstOperand, "/", secondOperand, firstOperand / secondOperand)
        );
    }

    @ParameterizedTest(name = "[{index}] : {0}{1}{2}={3}")
    @MethodSource
    @DisplayName("사칙 연산")
    void calculate(
        int firstOperand,
        String operator,
        int secondOperand,
        int expected
    ) {
        // When
        int actual = CalculatorV1.calculate(firstOperand, operator, secondOperand);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
