package org.example.grage_calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 1급 컬렉션
 * 리스트 타입의 course 정보만 인스턴스 변수로 가진다.
 */
public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 가변인자
     * @param courses
     */
    public Courses(Course ... courses) {
        this.courses = new ArrayList<>();
        for (Course course : courses) {
            this.courses.add(course);
        }
    }

    public double multipliyCreditCourseGrade() {
        /*double multipliedCreditCourseGrade = 0;
        for (Course course: this.courses) {
            multipliedCreditCourseGrade += course.getMultipliedCreditCourseGrade();
        }
        return multipliedCreditCourseGrade;*/

        /**
         * 리팩토링 - stream 메소드 참조 누적합
         */
        return courses.stream().mapToDouble(Course::getMultipliedCreditCourseGrade)
                .sum();
    }

    public int calcutateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(course -> course.getCredit())
                .sum();
    }
}
