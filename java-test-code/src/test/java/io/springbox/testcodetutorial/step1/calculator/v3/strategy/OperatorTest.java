package io.springbox.testcodetutorial.step1.calculator.v3.strategy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("V3:Operator")
class OperatorTest {

    private static Stream<Arguments> isSupport() {
        return Stream.of(
            Arguments.of(new Addition(), "+"),
            Arguments.of(new Minus(), "-"),
            Arguments.of(new Multiplication(), "*"),
            Arguments.of(new Divide(), "/")
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("연산자 지원 여부 검증")
    void isSupport(Operator operator, String given) {
        // When & Then
        assertTrue(operator.isSupport(given));
    }

}
