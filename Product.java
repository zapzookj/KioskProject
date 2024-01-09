package KioskProject;

import java.util.*;

public class Product extends Menu {
    int price;
    int quantity;
    List<String> coffeeNames = Arrays.asList("에스프레소", "아메리카노", "카페라떼", "카라멜마끼아또", "바닐라라떼");

    Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
        this.quantity = 1; // 상품이 처음 호출될 때, 수량은 1로 설정
    }

    void displayProduct(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
//            System.out.printf("%-3d. %-20s | %-5d원 | %s%n", i + 1 + ". " + product.name + "|" + product.price + "|" + product.description);
            System.out.printf("%-1d. %-10s | %-5d원 | %s%n", i + 1, product.name, product.price, product.description);
        }
    }

    void displayOrder(List<Product> products, int num) {
        for(Product productt : products){ // 카테고리내의 상품을 하나씩 조회
            if(coffeeNames.contains(productt.name)){ // 카테고리가 커피라면 첫 아이템인 "에스프레소"에서 무조건 걸리게됨
                Main.addShotOption(products.get(num - 1));
                break;
            }else{
                Product product = products.get(num - 1); // 배열은 0부터 시작..
//                System.out.println("디버깅"); // 위의 if문이 실행되고 나면 출력되지 않음
                super.name = product.name;
                super.description = product.description;
                this.price = product.price;
            }
        }
//        Product product = products.get(num - 1); // 배열은 0부터 시작..
//
//        super.name = product.name;
//        super.description = product.description;
//        this.price = product.price;

//        System.out.println(product.name + "   |" + product.price + "   |" + product.description);
        System.out.println(super.name + "   |" + this.price + "   |" + super.description); // 다 잘 동작하다가 여기서 무조건 에스프레소가 출력됨
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
    }

   void addShot(Product product, int add_num){
        if(add_num == 1){
            super.name = product.name + "(One shot add)";
            this.price += 500;
        }else if (add_num == 2){
            super.name = product.name + "(Two shot add)";
            this.price += 1000;
        }
   }

    void addCart() {
        Optional<Order> existingOrder = Main.Cart.stream().filter(order -> order.name.equals(super.name)).findFirst();
        if(existingOrder.isPresent()){
            Order order = existingOrder.get();
            order.quantity++;
            order.price *= order.quantity;
            Main.total_price += order.price;
        } else {
            Main.Cart.add(new Order(super.name, this.price, this.quantity, super.description));
            Main.total_price += price;
        }
    }
}
