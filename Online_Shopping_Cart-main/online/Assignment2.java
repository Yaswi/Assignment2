package online;

//import java.io.BufferedReader;  
//import java.io.FileReader;  
//import java.io.IOException;
import java.util.*;


// Custom exception : https://www.javatpoint.com/custom-exception

// class ItemNotFound extends Exception{
//    public ItemNotFound(String message){
//     super(message);
//    } 
// }

// class ItemAlreadyExists extends Exception{
//     public ItemAlreadyExists(String message){
//         super(message);
//     }
// }


// class Product{
//     String id;
//     String name;
//     double price;

//     public Product(String name,double price){
//         //here we are not adding id, cause we dont actually need to initialise and write method to get it
//         this.name=name;
//         this.price=price;
//     }
//     // to get the name
//     public String getName(){
//         return name;
//     }
//     // to get the price
//     public double getPrice(){
//         return price;
//     }
// }

// class ShoppingCart{
    
//     public static LinkedHashMap<String,Product> cart_items=new LinkedHashMap<>();

//     public void CartaddItem(String id,String name,double price ) throws ItemAlreadyExists{
//         if(cart_items.containsKey(id)){
//             throw new ItemAlreadyExists("The item that you're trying to add already exists");
//         }
//         Product p=new Product(name, price);
//         cart_items.put(id,p);
//         //System.out.println(cart_items.get(id));
//     }

//     public void CartRemove (String id) throws ItemNotFound{
//         if(!cart_items.containsKey(id)){
//             throw new ItemNotFound("The below item is not in the cart");
//         }
//         else{
//             cart_items.remove(id);
//         }
//     }

//     public void viewCartItems(){
//         for(Map.Entry<String,Product> entry: cart_items.entrySet()){
//             String id=entry.getKey();
//             Product p=entry.getValue();
//             String ID= id;  
//             String productname=p.getName();
//             double productprice= p.getPrice();
//             System.out.println(ID+" "+productname+" "+productprice);
//         }
//     }

//     public double calculate(){
//         double cost=0.0;
//         for(Map.Entry<String,Product>entry: cart_items.entrySet()){
//             Product p= entry.getValue();
//             double price_of_item= p.getPrice();
//             cost+= price_of_item;
//         }
//         return cost;
//     }

// }


// class Catalogue{
//     String id;
//     String name;
//     double price;

//     public void display(){
//         // using this object to access the global linkedhashmap.

//         LinkedHashMap<String,Product> products_list=Assignment2.products_list;
//         for(Map.Entry<String,Product> each_entry: products_list.entrySet()){
//             String id=each_entry.getKey();
//             Product p=each_entry.getValue();
//             String ID= id;  
//             String productname=p.getName();
//             double productprice= p.getPrice();
//             System.out.println(ID+" "+productname+" "+productprice);
//          }
//     }

//     public void addItem(String id, String name, double price){
//         LinkedHashMap<String,Product> products_list=Assignment2.products_list;
//         Product p=new Product(name, price);
//         products_list.put(id, p);
//     }

//     public void deleteItem(String id) throws ItemNotFound{
//         //LinkedHashMap<String,Product> products_list=Assignment2.products_list;
//         if(!Assignment2.products_list.containsKey(id)){
//             throw new ItemNotFound("The item is not available in the cart");
//         }
//         Assignment2.products_list.remove(id);
//     }
// }

public class Assignment2 {
    
    // Making a linkedhashmap global
    public static LinkedHashMap<String,Product>products_list=new LinkedHashMap<>();
    public static void main(String args[]) throws ItemAlreadyExists, ItemNotFound{
    Scanner sc=new Scanner(System.in);
    System.out.println("Welcome to the Menu");
    System.out.println("Please Enter the type of customer you are");
    System.out.println("1. Customer");
    System.out.println("2. Business owner");
    int choice=sc.nextInt();
    products_list=Read_csv.getProductList();
    //Explanation: https://www.javatpoint.com/how-to-read-csv-file-in-java
    // String line="";
    // String splitBy=",";
    // try
    // {
    //     //parsing the csv file to buffer reader class constructor
    //     BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Online_Shopping_Cart-main\\Online_Shopping_Cart-main\\products.csv"));
    //     //checking if the line is not null
    //     while((line=br.readLine())!=null){
    //         String[] product= line.split(splitBy);
            
    //         String id=product[0];
    //         String name=product[1];
    //         System.out.println(id);
    //         double price;
    //         try{

    //             price=Double.parseDouble(product[2]);
    //        }
    //         // here there is a numberformatexception,that comes when i try to convert the string to number, so try catch
    //         catch(NumberFormatException e){
    //         //   System.out.println("Wrong Number");
    //              continue;
    //          }
    //         Product p=new Product(name, price);
    //         System.out.println(id);
    //         products_list.put(id,p);
    //         System.out.println(id+" "+p.name);
    //     }
    // }
    // catch(IOException e){
    //     e.printStackTrace();
    // }

    while(true){
    switch(choice){
        case 1:
            System.out.println("Welcome to the menu");
            System.out.println("Enter your choice");
            System.out.println("1. View the Products Catalog");
            System.out.println("2. Add Items to the cart");
            System.out.println("3. Remove items from the cart");
            System.out.println("4. View the products in the cart");
            System.out.println("5. View the total cost of products in the shopping cart");
            System.out.println("Enter your choice");
            int input1= sc.nextInt();
            //ShoppingCart shopcart=(ShoppingCart)UserFactory.getObj(choice);
            ShoppingCart shopcart=new ShoppingCart();
            switch(input1){
                case 1:
                    Catalogue c=new Catalogue();
                    c.display();
                    break;
                case 2:
                    System.out.println("Enter the product ID");
                    String product_id=sc.next();
                    Product product= products_list.get(product_id);
                    //System.out.println(product);
                    if(product!=null){
                        String productname=product.getName();
                        double productprice=product.getPrice();
                        System.out.println(productname);
                        shopcart.CartaddItem(product_id,productname,productprice);
                    }
                    break;
                case 3:
                    System.out.println("Enter the product ID");
                    product_id= sc.next();
                    if(product_id!=null){
                        shopcart.CartRemove(product_id);
                    }
                    break;
                case 4:
                    shopcart.viewCartItems();
                    break;
                case 5:
                    System.out.println(shopcart.calculate());
                    break;
                default:
                    System.out.println("Please enter the correct ");
            }
            break;
        
        case 2:
            System.out.println("Welcome to the Menu Business partner");
            System.out.println("Enter your choice");
            System.out.println("1. View the Catalogue");
            System.out.println("2. Add Items to the catalogue");
            System.out.println("3. Remove items from the cart");
            int input2=sc.nextInt();
            // The userFactory.getObj basically gets a generic object
            // To convert that generic object to a specific required object,
            // we do the (class) Otherclass.method();
            //Catalogue c=(Catalogue)UserFactory.getObj(choice);
            Catalogue c= new Catalogue();
            switch(input2){
                case 1:
                    c.display();
                    break;
                case 2:
                    System.out.println("Please Enter the id, name and price of the product");
                    String id=sc.next();
                    String name= sc.next();
                    double price=sc.nextDouble();
                    c.addItem(id, name, price);
                    break;
                case 3:
                    System.out.println("Please Enter the product ID");
                    String product_id=sc.next();
                    if(product_id!=null){
                        c.deleteItem(product_id);
                    }
                    break;
                default:
                    System.out.println("Please enter the correct choice");

            }
            break;
            
            default:
                System.out.println("Default");


    }

    }


    }
}


