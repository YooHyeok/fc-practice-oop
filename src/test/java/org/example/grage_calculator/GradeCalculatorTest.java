package org.example.grage_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계/수강신청 총학점 수
 * 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    // 학점 계산기 도메인 : 이수한 과목(객체지향 프로그래밍, 자료구조, 중국어회화), 학점 계산기
    // 객체지향 프로그래밍, 자료구조, 중국어회화 -> 과목(코스) 클래스 : (동적인 객체를 정적인 타입으로 추상화하여 도메인 모델링)

    // 이수한 과목을 전달하여 평균학점 계산을 요청한다 ----> 학점 계산기 ----> (학점수 * 교과목 평점)의 합계 ----> 과목(코스)


    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(
                new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+")
                );


        /* 학점계산기 생성 (이수한 과목들 주입) */
        GradeCalculator gradeCalculator1 = new GradeCalculator(courses);
        double gradeResult1 = gradeCalculator1.calculateGrade(); // 성적 계산

        assertThat(gradeResult1).isEqualTo(4.5); // a+은 4.5점이다. 따라서 4.5*2  /2

        /* 가변인자를 사용해 봄 */
        GradeCalculator gradeCalculator2 = new GradeCalculator(new Course("OOP", 3, "A+"), new Course("자료구조", 3, "A+"));
        double gradeResult2 = gradeCalculator2.calculateGrade(); // 성적 계산
        assertThat(gradeResult2).isEqualTo(4.5); // a+은 4.5점이다. 따라서 4.5*2  /2
    }
}
