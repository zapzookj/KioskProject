package KioskProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Product extends Menu{
    int price;
    Product(String name, String description, int price){
        super(name, description);
        this.price = price;
    }
    void displayProduct(List<Product> products){
        for(int i = 0;i<products.size();i++){
            Product product = products.get(i);
            System.out.println(i+1 + ". " + product.name + "   |" + product.price + "원   |" + product.description);
        }
    }
    void displayOrder(List<Product> products, int num){
        Product product = products.get(num);
        super.name = product.name;
        super.description = product.description;
        this.price = product.price;
        System.out.println(product.name + "   |" + product.price + "   |" + product.description);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인      2. 취소");
    }

    void addCart(){
        Main.Cart.add(new Product(super.name, super.description, this.price));
        Main.total_price += price;
    }
}
