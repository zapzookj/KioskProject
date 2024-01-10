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
            System.out.printf("%-1d. %-10s | %s%n", i + startnumber, menu.name, menu.description);
        }
    }
}
