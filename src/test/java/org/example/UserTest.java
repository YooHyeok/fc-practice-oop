package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given : user객체가 주어졌다
        User user = new User();

        // when : 메소드를 호출했을 때
//        user.initPassword();
//        user.initPassword(new RandomPasswordGenerator());
        user.initPassword(new CorrectFixedPasswordGenerator());

        // then : 결과
        assertThat(user.getPassword()).isNotNull();
    }

}