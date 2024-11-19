package io.springbox.testcodetutorial.step1.calculator.v1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("V1:사칙 연산 계산기")
class CalculatorV1Test {

    @Test
    @DisplayName("덧셈 연산")
    void addition() {
        // Given
        final int firstOperand = 6;
        final String operator = "+";
        final int secondOperand = 3;
        final int expected = firstOperand + secondOperand;

        // When
        int actual = CalculatorV1.calculate(firstOperand, operator, secondOperand);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}
