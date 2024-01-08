package KioskProject;

public class Product extends Menu{
    int price;

    Product(String name, String description, int price){
        super(name, description);
        this.price = price;
    }
}
