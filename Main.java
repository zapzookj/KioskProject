package KioskProject;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, List<Menu>> menus = new HashMap<>();
    static Map<String, List<Product>> products = new HashMap<>();
    static List<Order> Cart = new ArrayList<>();
    static int total_price;

    static int order_number;


    public static void main(String[] args) {
        displayMainMenu();
    }

    static void InitialMenu() { // 메뉴판에 들어가야하는 메타 데이터를 초기화하는 메서드
        List<Menu> mainMenus = new ArrayList<>(); // 메인 메뉴판의 정보를 담을 리스트 선언(Menu 생성자 이용)
        mainMenus.add(new Menu("Coffee", "좋은 원두를 사용하는 맛있는 커피")); // 리스트에 각 카테고리의 내용을 추가
        mainMenus.add(new Menu("Beverage", "매장에서 직접 만드는 다양한 음료수"));
        mainMenus.add(new Menu("Bread", "갓 구운 맛있는 빵"));
        mainMenus.add(new Menu("Cake", "뭔가 특별한 케이크"));

        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));

        menus.put("Main menu", mainMenus); // 선언한 리스트를 키값과 함께 전역변수로 선언해둔 해쉬맵에 저장
        menus.put("Order menu", orderMenus);

        List<Product> coffeeProducts = new ArrayList<>(); // 특정 카테고리 안 상품의 정보를 담을 리스트 선언(Product 생성자 이용)
        coffeeProducts.add(new Product("에스프레소", "Espresso", 2500)); // 리스트에 각 내용 추가
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

        products.put("Coffee", coffeeProducts); // 선언한 각각의 카테고리 상품 정보를 해쉬맵에 저장
        products.put("Beverage", beverageProducts);
        products.put("Bread", breadProducts);
        products.put("Cake", cakeProducts);
    }
    static void displayMainMenu() { // 메인 메뉴판을 출력하는 메서드
        InitialMenu(); // 메뉴판을 출력하기 전 메뉴판 정보 초기화
        List<Menu> mainMenuList = menus.get("Main menu");
        List<Menu> mainOrderList = menus.get("Order menu");
        System.out.println("PARIS BAGUETTE에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ PARIS BAGUETTE MENU ]");
        mainMenuList.get(0).displayMenu(mainMenuList, 1);
        System.out.println("\n[ ORDER MENU ]");
        mainOrderList.get(0).displayMenu(mainOrderList, 5);

        int choice = getUserChoice(); // 메인 메뉴판에서 사용자에게 입력을 받음
        if (choice == 1) { // 사용자의 입력 별 조건문 분기
            handleMainMenuChoice(choice, "Coffee");
        } else if (choice == 2) {
            handleMainMenuChoice(choice, "Beverage");
        } else if (choice == 3) {
            handleMainMenuChoice(choice, "Bread");
        } else if (choice == 4) {
            handleMainMenuChoice(choice, "Cake");
        } else if (choice == 5) {
            showCart();
        } else if (choice == 6) {
            cancelOrder();
        }
        else {
            System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴로 돌아갑니다.");
            displayMainMenu();
        }
    }

    static void handleMainMenuChoice(int choice, String category) { // 상품 카테고리 선택 시 상품 정보 출력 메서드
        List<Product> productList = products.get(category); // get 명령어를 통해 입력받은 카테고리에 맞는 데이터를 불러옴

        System.out.println("\nPARIS BAGUETTE에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보고 메뉴를 골라 입력해주세요.\n");
        switch(choice){ // 사용자가 입력한 숫자에 맞는 카테고리 메뉴 표시
            case 1:
                System.out.println("[ Coffee MENU ]");
                break;
            case 2:
                System.out.println("[ Beverage MENU ]");
                break;
            case 3:
                System.out.println("[ Bread MENU ]");
                break;
            case 4:
                System.out.println("[ Cake MENU ]");
                break;
            default:
                System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴로 돌아갑니다.");
                displayMainMenu();
                return;
        }
        productList.get(0).displayProduct(productList); // displayProduct 메서드를 통해 상품 정보 출력

        int choice2 = getUserChoice(); // 사용자에게 장바구니에 담을 상품을 입력 받음
//        for(Product product : productList){
//            if(product.equals("아메리카노")){
//                addShotOption();
//                break;
//            }
//        }
        handleOrderChoice(productList, choice2); // 주문 확인창으로 넘어감
    }

    static void handleOrderChoice(List<Product> productList,int choice){
        productList.get(0).displayOrder(productList, choice); // 주문 확인창 출력
        int choice3 = getUserChoice(); // 다시 사용자에게 주문 여부를 입력 받음
        handleAddOrder(choice3, productList); // 주문 결과 창으로 넘어감
    }
    static void handleOrderChoice(List<Product> productList){

    }

    static void addShotOption(Product product){
        System.out.println(product.name + "   |" + product.price + "원   |" + product.description);
        System.out.println("커피에 샷을 추가하시겠습니까?");
        System.out.println("1. One shot add(500원)     2. Two shot add(1000원)     3. 샷 추가 X");
        int choice = getUserChoice();
        if(choice == 1 || choice == 2){
            product.addShot(product, choice);
        }
    }
    static void handleAddOrder(int choice, List<Product> productList){
        if(choice == 1){ // 입력받은 숫자에 따라 주문 결과를 출력
            productList.get(0).addCart(); // 주문을 입력받았다면 장바구니에 상품을 추가
            System.out.println("상품이 장바구니에 담겼습니다. 메인 메뉴판으로 돌아갑니다.");
            displayMainMenu();
        }else if(choice == 2){
            System.out.println("취소하셨습니다. 메인 메뉴판으로 돌아갑니다.");
            displayMainMenu();
        }else{
            System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴판으로 돌아갑니다.");
            displayMainMenu();
        }
    }

    static void showCart(){
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for(int i =0; i<Cart.size(); i++){
            Order order = Cart.get(i);
            System.out.println(order.name + "   |" + order.price + "원   |" + order.quantity + "개   |" +order.description);
        }
        System.out.println("[ Total ]");
        System.out.println(total_price + "원\n");
        System.out.println("1. 주문      2. 메뉴판");

        int choice = getUserChoice();
        if(choice == 1){
            completeOrder();
        }else if(choice == 2){
            displayMainMenu();
        }else{
            System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴판으로 돌아갑니다.");
            displayMainMenu();
        }
    }

    static void completeOrder(){
        System.out.println("주문이 완료되었습니다!");

        order_number++;
        Cart.clear();
        total_price = 0;
        System.out.printf("대기번호는 [ %d ] 번 입니다.", order_number);
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        displayMainMenu();
    }
    static void cancelOrder(){
        System.out.println("진행중인 주문을 취소하시겠습니까?");
        System.out.println("1. 확인     2. 취소");
        int choice = getUserChoice();
        if(choice == 1){
            clearCart();
        }else if(choice == 2){
            System.out.println("취소하셨습니다. 메인 메뉴판으로 돌아갑니다");
            displayMainMenu();
        }else{
            System.out.println("잘못된 값이 입력되었습니다. 메인 메뉴판으로 돌아갑니다");
            displayMainMenu();
        }
    }

    static void clearCart(){
        System.out.println("진행중인 주문이 모두 취소되었습니다.");
        Cart.clear();
        total_price = 0;
        displayMainMenu();
    }

    static int getUserChoice() {
        System.out.print("원하시는 요청을 골라주세요 : ");
        return scanner.nextInt();
    }
}
