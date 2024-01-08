package KioskProject;
import java.util.List;
import java.util.Map;

public class Menu {
    String name;
    String description;

    Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    void displayMenu(Map<String, Menu> menus, Map<String, Menu> menus2) {
        System.out.println("PARIS BAGUETTE에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보고 메뉴를 골라 입력해주세요.");
        System.out.println("[ PARIS BAGUETTE MENU ]");

//        for (int i = 0; i < menus.size(); i++) {
//            Menu menu = menus.get(i);
//            System.out.println((i + 1) + ". " + menu.name + "   | " + menu.description);
//        }
//        for (int i = 0; i < menus2.size(); i++) {
//            Menu menu = menus2.get(i);
//            System.out.println((i + 1) + ". " + menu.name + "   | " + menu.description);
//        }
//        System.out.println(menus.get("Main menu"));
//        System.out.println(menus2.get("Order menu"));
        for (Map.Entry<String, Menu> entry : menus.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name + "   | " + entry.getValue().description);
        }
    }
}
