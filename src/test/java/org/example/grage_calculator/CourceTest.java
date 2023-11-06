package org.example.grage_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CourceTest {

    @DisplayName("과목(코스)를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException(); // 코스가 정상적으로 생성되어 어떤 익셉션도 발생하지 않는다.
    }
}
