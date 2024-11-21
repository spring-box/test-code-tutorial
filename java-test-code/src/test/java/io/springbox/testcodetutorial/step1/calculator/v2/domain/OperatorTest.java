package io.springbox.testcodetutorial.step1.calculator.v2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("V2:Domain:Operand")
class OperatorTest {

    private static Stream<Arguments> operate() {
        final int firstPositiveOperand = PositiveOperand.from(6).value();
        final int secondPositiveOperand = PositiveOperand.from(3).value();

        return Stream.of(
            Arguments.of(
                Operator.ADDITIONAL,
                firstPositiveOperand,
                secondPositiveOperand,
                firstPositiveOperand + secondPositiveOperand
            ),
            Arguments.of(
                Operator.MINUS,
                firstPositiveOperand,
                secondPositiveOperand,
                firstPositiveOperand - secondPositiveOperand
            ),
            Arguments.of(
                Operator.MULTIPLICATION,
                firstPositiveOperand,
                secondPositiveOperand,
                firstPositiveOperand * secondPositiveOperand
            ),
            Arguments.of(
                Operator.DIVIDE,
                firstPositiveOperand,
                secondPositiveOperand,
                firstPositiveOperand / secondPositiveOperand
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("사칙 연산")
    void operate(
        Operator given,
        int firstPositiveOperand,
        int secondPositiveOperand,
        int expected
    ) {
        // When
        int actual = given.operate(firstPositiveOperand, secondPositiveOperand);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @EnumSource(value = Operator.class)
    @DisplayName("사칙 연산자 Enum 생성")
    void operator(Operator given) {
        // When & Then
        assertThat(given).isInstanceOf(Operator.class);
    }

}
