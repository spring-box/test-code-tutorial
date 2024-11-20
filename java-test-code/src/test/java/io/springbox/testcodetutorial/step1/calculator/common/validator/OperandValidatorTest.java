package io.springbox.testcodetutorial.step1.calculator.common.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import io.springbox.testcodetutorial.step1.calculator.common.exception.IsNotPositiveOperandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("V1:Validator:Operand")
class OperandValidatorTest {

    @Nested
    @DisplayName("피연산자 양수 여부 검증")
    class PositiveOperandValidatorTest {

        @ParameterizedTest
        @ValueSource(ints = {-1, -2, -3})
        @DisplayName("[예외] 피 연산자가 음수인 경우")
        void throwException_whenOperandIsNotPositive(int given) {
            // When & Then
            assertThatExceptionOfType(IsNotPositiveOperandException.class)
                .isThrownBy(() -> OperandValidator.validateOperandIsPositive(given));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        @DisplayName("피연산자가 양수인 경우 유효성 검증 통과")
        void passValidate_whenOperandIsPositive(int given) {
            // When & Then
            assertDoesNotThrow(() -> OperandValidator.validateOperandIsPositive(given));
        }

    }

    @Nested
    @DisplayName("제수의 0 여부 검증")
    class NegativeDivisorValidatorTest {

        @DisplayName("[예외] 제수가 0인 경우")
        void throwException_whenOperandIsNegative() {
            // Given
            final int given = 0;

            // When & Then
            assertThatExceptionOfType(IsNotPositiveOperandException.class)
                .isThrownBy(() -> OperandValidator.validateDivisor(given));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2})
        @DisplayName("제수가 0이 아닌 경우 유효성 검증 통과")
        void passValidate_whenDivisorIsNotZero(int given) {
            // When & Then
            assertDoesNotThrow(() -> OperandValidator.validateDivisor(given));
        }

    }

}
