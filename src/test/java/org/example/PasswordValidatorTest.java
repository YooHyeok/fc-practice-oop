package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


/**
 * 테스트코드를 작성하는 이유
 * 1. 문서화 역활
 * 2. 코드에 결함을 발견하기 위함
 * 3. 리팩토링시 (심리적)안정성 확보
 * 4. 테스트하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음.
 *
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.") // 테스트코드의 의도를 작성 - 1. 문서화 역활
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValdator.validate("serverwizard"))
                .doesNotThrowAnyException(); // 익셉션 발생하지 않음 확인 - 호출시 익셉션 발생하지 않을경우 테스트 통과
    }

    /**
     * 경계값 테스트
     * @ParameterizedTest : https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/
     * @param password
     */
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest //
    @ValueSource(strings = {"1234567", "1234567891234"})
    @Test
    void validatePasswordTest2(String password) { // ValueSrouce에 지정한 strings 값들이 차례로 파라미터로 사용된다.
        assertThatCode(() -> PasswordValdator.validate(password))
                .isInstanceOf(IllegalArgumentException.class) // 익셉션 발생시 발생한 익셉션 클래스의 타입 비교
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다."); // 익셉션 발생시 발생한 메시지 비교
    }

}
