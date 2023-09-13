package online;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class Read_csv {
    public static LinkedHashMap<String, Product> getProductList(){
        LinkedHashMap<String,Product>pl=new LinkedHashMap<>();
        String line="";
        String splitBy=",";
    try
    {
        //parsing the csv file to buffer reader class constructor
        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\Online_Shopping_Cart-main\\Online_Shopping_Cart-main\\products.csv"));
        //checking if the line is not null
        while((line=br.readLine())!=null){
            String[] product= line.split(splitBy);
            
            String id=product[0];
            String name=product[1];
            //System.out.println(id);
            double price;
            try{

                price=Double.parseDouble(product[2]);
           }
            // here there is a numberformatexception,that comes when i try to convert the string to number, so try catch
            catch(NumberFormatException e){
            //   System.out.println("Wrong Number");
                 continue;
             }
            Product p=new Product(name, price);
            //System.out.println(id);
            pl.put(id,p);
        }
    }
    catch(IOException e){
        e.printStackTrace();
    }
    return pl;
    }
    
}
