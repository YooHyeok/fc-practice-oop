package org.example.customer;

public class Customer {

    public void order(String menuname, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(menuname); //메뉴선택(여부 학인 Exception)
        Cook cook = cooking.makeCook(menuItem);//요리 시작
    }
}
