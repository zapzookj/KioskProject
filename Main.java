package KioskProject;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Menu> menus = new HashMap<>();
    static Map<String, Product> products = new HashMap<>();


    public static void main(String[] args) {
        displayMainMenu();
    }

    static void InitialMenu() {
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("Coffee", "좋은 원두를 사용하는 맛있는 커피"));
        mainMenus.add(new Menu("Beverage", "매장에서 직접 만드는 다양한 음료수"));
        mainMenus.add(new Menu("Bread", "갓 구운 맛있는 빵"));
        mainMenus.add(new Menu("Cake", "뭔가 특별한 케이크"));

        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        Map<String, Menu> menus = new HashMap<>();
//        menus.put("Main menu", mainMenus);
//        menus.put("Order menu", orderMenus);
        for (Menu menu : mainMenus) {
            menus.put(menu.name, menu);
        }
        for (Menu menu : orderMenus) {
            menus.put(menu.name, menu);
        }

        List<Product> coffeeProducts = new ArrayList<>();
        coffeeProducts.add(new Product("에스프레소", "Espresso", 2500));
        coffeeProducts.add(new Product("아메리카노", "Americano", 2500));
        coffeeProducts.add(new Product("카페라떼", "Cafe latte", 3000));
        coffeeProducts.add(new Product("카라멜마끼아또", "Caramel ..", 3500));
        coffeeProducts.add(new Product("바닐라라떼", "Vanilla latte", 4000));

        List<Product> beverageProducts = new ArrayList<>();
        beverageProducts.add(new Product("스팀우유", "Milk", 2000));
        beverageProducts.add(new Product("홍차", "Tea", 3000));
        beverageProducts.add(new Product("아이스티", "Ice tea", 2500));
        beverageProducts.add(new Product("자색고구마라떼", "goguma", 4300));

        List<Product> breadProducts = new ArrayList<>();
        breadProducts.add(new Product("메론크림빵", "맛있는 메론크림빵", 2800));
        breadProducts.add(new Product("초코소라빵", "초코가 아주 많다", 1900));
        breadProducts.add(new Product("슈크림빵", "이것은 근본이다", 1900));
        breadProducts.add(new Product("생딸기우유샌드", "진짜 딸기임", 3700));
        breadProducts.add(new Product("단팥생크림빵", "팥팥팥", 2900));

        List<Product> cakeProducts = new ArrayList<>();
        cakeProducts.add(new Product("트윙클 에두아르 쇼콜라", "뭔가 있어보이는 케이크", 29000));
        cakeProducts.add(new Product("생딸기 초코프레지에", "맛있음", 33000));
        cakeProducts.add(new Product("블레싱 초코베리", "가성비 좋은 케이크", 28000));
        cakeProducts.add(new Product("순수우유케이크", "클래식한 케이크", 27000));

        Map<String, Product> products = new HashMap<>();
//        products.put("Coffee", coffeeProducts);
//        products.put("Beverage", beverageProducts);
//        products.put("Bread", breadProducts);
//        products.put("Cake", cakeProducts);
        for (Product product : coffeeProducts) {
            products.put(product.name, product);
        }
        for (Product product : beverageProducts) {
            products.put(product.name, product);
        }
        for (Product product : breadProducts) {
            products.put(product.name, product);
        }
        for (Product product : cakeProducts) {
            products.put(product.name, product);
        }
    }
    static void displayMainMenu() {
        InitialMenu();
        menus.get("Main menu").displayMenu(menus);

        int choice = getUserChoice();
        if (choice == 1) {
            handleMainMenuChoice(choice, coffeeProducts);
        } else if (choice == 2) {
            handleMainMenuChoice(choice, beverageProducts);
        } else if (choice == 3) {
            handleMainMenuChoice(choice, breadProducts);
        } else if (choice == 4) {
            handleMainMenuChoice(choice, cakeProducts);
        } else {
            System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴로 돌아갑니다.");
            displayMainMenu();
        }
    }

    static void handleMainMenuChoice(int choice, List<Product> products) {

    }

    static int getUserChoice() {
        System.out.print("원하시는 요청을 골라주세요 : ");
        return scanner.nextInt();
    }
}
