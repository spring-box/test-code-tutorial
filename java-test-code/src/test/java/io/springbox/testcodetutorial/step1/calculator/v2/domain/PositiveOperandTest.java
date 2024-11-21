package io.springbox.testcodetutorial.step1.calculator.v2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import io.springbox.testcodetutorial.step1.calculator.common.exception.IsNotPositiveOperandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("V2:Domain:PositiveOperand")
class PositiveOperandTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("양수인 피연산자 객체 생성")
    void create(int given) {
        // When
        PositiveOperand actual = PositiveOperand.from(given);

        // Then
        assertThat(actual.value()).isEqualTo(given);
    }

    @Test
    @DisplayName("[예외]피 연산자가 양수가 아닌 경우")
    void throwException_GivenNotPositiveOperand() {
        // Given
        final int given = -1;

        // When & Then
        assertThatExceptionOfType(IsNotPositiveOperandException.class)
            .isThrownBy(() -> PositiveOperand.from(given));
    }

}
