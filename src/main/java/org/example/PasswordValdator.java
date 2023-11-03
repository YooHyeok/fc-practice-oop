package org.example;

public class PasswordValdator {
    public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 한다."; // 전역변수(상수) 추출 단축키 :Ctrl + Alt + C
    public static void validate(String password) {
        int length = password.length(); // 지역변수 추출 단축키 : Ctrl + Alt + v (replace 2~...)
        if (length < 8 || length > 12) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
