package KioskProject;
public class Order{
    String name;
    String description;
    int price;
    int quantity;

    Order(String name, int price, int quantity, String description){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
