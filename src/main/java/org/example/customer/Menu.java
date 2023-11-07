package org.example.customer;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String menuname) {
        return menuItems.stream()
                .filter(menuItem -> menuItem.getName().equals(menuname))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴 이름입니다."));
    }
}
