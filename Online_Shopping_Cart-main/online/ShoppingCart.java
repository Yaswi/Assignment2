package online;
import java.util.*;

class ShoppingCart{
    
    public static LinkedHashMap<String,Product> cart_items=new LinkedHashMap<>();

    public void CartaddItem(String id,String name,double price ) throws ItemAlreadyExists{
        if(cart_items.containsKey(id)){
            throw new ItemAlreadyExists("The item that you're trying to add already exists");
        }
        Product p=new Product(name, price);
        cart_items.put(id,p);
        //System.out.println(cart_items.get(id));
    }

    public void CartRemove (String id) throws ItemNotFound{
        if(!cart_items.containsKey(id)){
            throw new ItemNotFound("The below item is not in the cart");
        }
        else{
            cart_items.remove(id);
        }
    }

    public void viewCartItems(){
        for(Map.Entry<String,Product> entry: cart_items.entrySet()){
            String id=entry.getKey();
            Product p=entry.getValue();
            String ID= id;  
            String productname=p.getName();
            double productprice= p.getPrice();
            System.out.println(ID+" "+productname+" "+productprice);
        }
    }

    public double calculate(){
        double cost=0.0;
        for(Map.Entry<String,Product>entry: cart_items.entrySet()){
            Product p= entry.getValue();
            double price_of_item= p.getPrice();
            cost+= price_of_item;
        }
        return cost;
    }

}