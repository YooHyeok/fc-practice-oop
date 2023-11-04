package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    /**
     * 1) 1 + 2 ---> Calculator
     * 2)  3 <--- Calculator
     *
     * 1) 두개의 p연산자와 하나의 연산자를 Calculator에게 전달하면서 작업을 위임한다.
     * 2) 작업을 완료한 후 Calculator가 값을 반환한다.
     */
    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {
        int result = Calculator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);

    }
}
