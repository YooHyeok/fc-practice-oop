package org.example;

public class User {
    private String password;

    /**
     * [as-is]
     * 랜덤 패스워드의 길이가 8이상 12이하일 경우 password value를 랜덤패스워드 value로 초기화
     */
    public void initPassword() {

        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); // as-is
        String randomPassword = randomPasswordGenerator.generatePassword();

        /* 랜덤 패스워드의 길이가 8이상 12이하일 경우 password value를 랜덤패스워드 value로 초기화*/
        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }

    /**
     * [to-be]
     * PasswordGenerator 인터페이스를 통해 낮은 결합도를 가진 설계를 얻게됨
     * 따라서, 해당 메소드는 Random 혹은 Correct, Wrong 3가지의 구현체 클래스를 주입받을 수 있으므로 유연해진다.
     * 상위 인터페이스를 통해 메소드 호출
     * @param passwordGenerator
     */
    public void initPassword(/* to-be */PasswordGenerator passwordGenerator) {
        String password = passwordGenerator.generatePassword();

        /* 랜덤 패스워드의 길이가 8이상 12이하일 경우 password value를 랜덤패스워드 value로 초기화*/
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
