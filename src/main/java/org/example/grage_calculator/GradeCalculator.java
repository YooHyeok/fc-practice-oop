package org.example.grage_calculator;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {

    private final Courses coursess; // 1급 컬렉션
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.coursess = new Courses(courses); //1급 컬렉션에게 위임
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
        this.coursess = new Courses(courses); //1급 컬렉션에게 위임

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

    public double calculateGrade1() {

        /* (credit * grade) 총 합계 */
        double multipliedCreditCourseGrade = 0;
        /*
         * 응집도를 높힘으로써 학점수 * 교과목 평균 연산에 대한 수정이 필요할때 한곳에서만 수정할 수 있도록.
         * 만약 해당 로직이 여러곳에서 중복으로 사용하고 있다면 일일히 찾아가서 수정해야함.
         * 리팩토링: course객체의 getter함수를 통해 연산 작업을 위임
         */
        for (Course course: this.courses) {
            multipliedCreditCourseGrade += course.getMultipliedCreditCourseGrade();
        }

        /* 수강신청 총 학점 수 */
        int totalCompletedCredit = courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
        return multipliedCreditCourseGrade / totalCompletedCredit;
    }

    /**
     * 1급 컬렉션 리팩토링
     * @return
     */
    public double calculateGrade2() {

        /* (credit * grade) 총 합계 */
        double totalMultipliedCreditCourseGrade = coursess.multipliyCreditCourseGrade();
        /* 수강신청 총 학점 수 */
        int totalCompletedCredit = coursess.calcutateTotalCompletedCredit();

        return totalMultipliedCreditCourseGrade / totalCompletedCredit;
    }

}
