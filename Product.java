package KioskProject;

import java.util.List;
import java.util.Optional;

public class Product extends Menu {
    int price;
    int quantity;

    Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
        this.quantity = 1; // 상품이 처음 호출될 때, 수량은 1로 설정
    }

    void displayProduct(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println(i + 1 + ". " + product.name + "   |" + product.price + "원   |" + product.description);
        }
    }

    void displayOrder(List<Product> products, int num) {
        Product product = products.get(num - 1); // 배열은 0부터 시작..

        super.name = product.name;
        super.description = product.description;
        this.price = product.price;

        System.out.println(product.name + "   |" + product.price + "   |" + product.description);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
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
