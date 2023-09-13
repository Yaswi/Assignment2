package online;

public class Product{
    private String id;
    private String name;
    private double price;

    public Product(String name,double price){
        //here we are not adding id, cause we dont actually need to initialise and write method to get it
        this.name=name;
        this.price=price;
    }
    // to get the name
    public String getName(){
        return name;
    }
    // to get the price
    public double getPrice(){
        return price;
    }
}

