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

    public int getCredit() {
        return credit;
    }

    /**
     * 문자 성적을 숫자로 바꾸는 메소드
     * @return
     */
    public double getGradeToNumber() {
        double grade = 0;
        switch (this.grade) {
            case "A+":
                grade = 4.5;
                break;
            case "A":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C":
                grade = 2.0;
        }
        return grade; // 없는 성적ㅇ느 0점으로 처리 (D부터 F)
    }
}
