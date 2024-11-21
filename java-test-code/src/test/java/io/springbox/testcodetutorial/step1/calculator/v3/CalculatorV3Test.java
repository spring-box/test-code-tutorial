package io.springbox.testcodetutorial.step1.calculator.v3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import io.springbox.testcodetutorial.step1.calculator.Calculator;
import io.springbox.testcodetutorial.step1.calculator.common.exception.IsNotPositiveOperandException;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotDividedZeroException;
import io.springbox.testcodetutorial.step1.calculator.common.exception.NotSupportedOperatorException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("V3:사칙 연산 계산기")
class CalculatorV3Test {

    private final Calculator sut = new CalculatorV3();

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

    private static Stream<Arguments> throwException_whenOperandIsNotPositive() {
        final List<String> operators = List.of("+", "-", "*", "/");
        final int negativeOperand = -1;
        final int positiveOperand = 1;

        return operators.stream()
            .flatMap(operator -> Stream.of(
                Arguments.of(negativeOperand, operator, positiveOperand),
                Arguments.of(positiveOperand, operator, negativeOperand)
            ));
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
        int actual = sut.calculate(firstOperand, operator, secondOperand);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("[예외] 나누는 수가 0인 경우")
    void throwException_whenDividedZero() {
        // Given
        final int firstOperand = 3;
        final String operator = "/";
        final int secondOperand = 0;

        // When & Then
        assertThatExceptionOfType(NotDividedZeroException.class)
            .isThrownBy(() -> sut.calculate(firstOperand, operator, secondOperand));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("[예외] 피 연산자가 양수가 아닌 경우")
    void throwException_whenOperandIsNotPositive(
        int firstOperand,
        String operator,
        int secondOperand
    ) {
        // When & Then
        assertThatExceptionOfType(IsNotPositiveOperandException.class)
            .isThrownBy(() -> sut.calculate(firstOperand, operator, secondOperand));
    }

    @ParameterizedTest
    @ValueSource(strings = {"%", "^"})
    @DisplayName("[예외] 사칙 연산자가 아닌 경우")
    void throwException_whenIsNotSupportedOperator(String given) {
        // Given
        final int firstOperand = 6;
        final int secondOperand = 3;

        // When & Then
        assertThatExceptionOfType(NotSupportedOperatorException.class)
            .isThrownBy(() -> sut.calculate(firstOperand, given, secondOperand));
    }

}
