package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


/**
 * 테스트코드를 작성하는 이유
 * 1. 문서화 역활
 * 2. 코드에 결함을 발견하기 위함
 * 3. 리팩토링시 (심리적)안정성 확보
 * 4. 테스트하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음.
 */
public class PasswordValidatorTest {
    /**
     * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
     * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
     * 경계조건에 대해 테스트 코드를 작성해야 한다.
     */
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.") // 테스트코드의 의도를 작성 - 1. 문서화 역활
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValdator.validate("serverwizard"))
                .doesNotThrowAnyException(); // 익셉션 발생하지 않음 확인 - 호출시 익셉션 발생하지 않을경우 테스트 통과
    }
}
