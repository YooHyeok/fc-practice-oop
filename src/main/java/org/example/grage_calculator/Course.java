package org.example.grage_calculator;

public class Course {

    private final String subject; // 과목 명
    private final int credit;
    private final String grade;


    /**
     * @param subject  : 교과목 이름
     * @param credit   : 학점
     * @param grade    : 성적 정보
     */
    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }
}
