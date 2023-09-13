package online;
import java.util.*;

public class Catalogue{
    String id;
    String name;
    double price;

    public void display(){
        // using this object to access the global linkedhashmap.
        LinkedHashMap<String,Product> products_list=Assignment2.products_list;
        for(Map.Entry<String,Product> each_entry: products_list.entrySet()){
            String id=each_entry.getKey();
            Product p=each_entry.getValue();
            String ID= id;  
            String productname=p.getName();
            double productprice= p.getPrice();
            System.out.println(ID+" "+productname+" "+productprice);
         }
    }

    public void addItem(String id, String name, double price){
        LinkedHashMap<String,Product> products_list=Assignment2.products_list;
        Product p=new Product(name, price);
        products_list.put(id, p);
    }

    public void deleteItem(String id) throws ItemNotFound{
        //LinkedHashMap<String,Product> products_list=Assignment2.products_list;
        if(!Assignment2.products_list.containsKey(id)){
            throw new ItemNotFound("The item is not available in the cart");
        }
        Assignment2.products_list.remove(id);
    }
}
