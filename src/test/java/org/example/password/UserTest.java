package org.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 더 낮은 결합도를 가진 설계를 얻는 경우
 * RandomPasswordGenerator의 상위 인터페이스를 구현하여
 * 두가지 조건을 추가하여 테스트
 * 낮은 결합도 : RandomPasswordGenerator 상위 인터페이스 설계함으로써 기존 강하게 결합되어있는 것이 유연하게 교체가 가능해짐
 */
class UserTest {

    /**
     * 항상 초기화되는 케이스
     */
    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given : user객체가 주어졌다
        User user = new User();

        // when : 메소드를 호출했을 때
//        user.initPassword();
//        user.initPassword(new RandomPasswordGenerator());
        user.initPassword(new CorrectFixedPasswordGenerator()); //8글자 고정

        // then : 결과
        assertThat(user.getPassword()).isNotNull();
    }

    /**
     * 항상 초기화되지 않는 케이스
     */
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given : user객체가 주어졌다
        User user = new User();

        // when : 메소드를 호출했을 때
        user.initPassword(new WrongFixedPasswordGenerator()); //2글자 고정

        // then : 결과
        assertThat(user.getPassword()).isNull();
    }

    /**
     * 두 케이스의 낮은 결합도 구현체 인스턴스 대신 람다식 적용
     */
    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest3() {
        // given : user객체가 주어졌다
        User userA = new User();
        User userB = new User();

        // when : 메소드를 호출했을 때
        userA.initPassword(() -> "12345678"); //8글자 고정
        userB.initPassword(() -> "ab"); //2글자 고정

        // then : 결과
        assertThat(userA.getPassword()).isNotNull();
        assertThat(userB.getPassword()).isNull();
    }
}