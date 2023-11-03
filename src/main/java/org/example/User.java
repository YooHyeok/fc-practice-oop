package org.example;

public class User {
    private String password;

    /**
     * 랜덤 패스워드의 길이가 8이상 12이하일 경우 password value를 랜덤패스워드 value로 초기화
     */
    public void initPassword() {

        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String randomPassword = randomPasswordGenerator.generatePassword();

        /* 랜덤 패스워드의 길이가 8이상 12이하일 경우 password value를 랜덤패스워드 value로 초기화*/
        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }

    public String getPassword() {
        return password;
    }
}
