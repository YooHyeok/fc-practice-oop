package org.example.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CookTest {

    @DisplayName("요리를 생성한다")
    @Test
    void createTest() {
        assertThatCode(() -> new Cook("만두", 5000))
                .doesNotThrowAnyException(); // 요리 생성 후 어떠한 익셉션도 발생하지 않는다.
    }
}
