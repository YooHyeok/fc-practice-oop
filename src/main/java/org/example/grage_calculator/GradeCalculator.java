package org.example.grage_calculator;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 가변인자 방식
     * @param courses
     */
    public GradeCalculator(Course ...courses) {
        this.courses = new ArrayList<>();
        for (Course course : courses) {
            this.courses.add(course);

        }
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계/수강신청 총학점 수
     * 일급 컬렉션 사용
     */
    public double calculateGrade() {

        /* (credit * grade) 총 합계 */
        double multipliedCreditCourseGrade = 0;
        for (Course course: this.courses) {
            multipliedCreditCourseGrade += course.getCredit() * course.getGradeToNumber();
        }

        /* 수강신청 총 학점 수 */
        int totalCompletedCredit = courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
        return multipliedCreditCourseGrade / totalCompletedCredit;
    }
}
