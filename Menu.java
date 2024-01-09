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

    void displayMenu(List<Menu> menuList, int startnumber) {

        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.println((i + startnumber) + ". " + menu.name + "   | " + menu.description);
        }

//        System.out.println(menus.get("Main menu"));
//        System.out.println(menus2.get("Order menu"));
//        for (Map.Entry<String, List<Menu>> entry : menus.entrySet()) {
//            System.out.println(entry.getKey() + ". " + entry.getValue().name + "   | " + entry.getValue().description);
//        }
    }
}
