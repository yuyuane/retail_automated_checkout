/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author yuyua
 */
public class ProductMap {
    HashMap<String,Product> productList;
    String message;
    
    public ProductMap(){
        this.allProduct();
    }
    
    public static void main(String[] args) {
        ProductMap productAll = new ProductMap();
        System.out.println(productAll.toString());
    }
    
    /**
     * chips, crackers, nuts, candy, cookies
     * apple, banana, orange, pear, grapes, strawberry, mango
     * soda, milk, beer
     */
    public void allProduct(){
       productList = new HashMap<>();
       Product cup = new Product(1,"cup",5.1);
       productList.put("cup", cup);
       Product pen = new Product(2,"pen",1.0);
       productList.put("pen", pen);
       Product chips = new Product(3,"chips",2.2);
       productList.put("chips", chips);
       Product crackers = new Product(4,"crackers",1.5);
       productList.put("crackers", crackers);
       Product nuts = new Product(5,"nuts",4.0);
       productList.put("nuts", nuts);
       Product candy = new Product(6,"candy",1.1);
       productList.put("candy", candy);
       Product cookies = new Product(7,"cookies",1.39);
       productList.put("cookies", cookies);
       Product apple = new Product(8,"apple",1.0);
       productList.put("apple", apple);
       Product banana = new Product(9,"banana",1.0);
       productList.put("banana", banana);
       Product orange = new Product(10,"orange",2.29);
       productList.put("orange", orange);
       Product soda = new Product(11,"soda",2.0);
       productList.put("soda", soda);
       Product milk = new Product(12,"milk",1.1967);
       productList.put("milk", milk);
       Product beer = new Product(13,"beer",2.69);
       productList.put("beer", beer);
       Product strawberry = new Product(14,"strawberry",2.89);
       productList.put("strawberry", strawberry);
    }
    
    public Product getProduct(String name){
        Product product = productList.get(name);
        return product;
    }
    
    @Override
    public String toString(){
        for (Product product: productList.values()) {
            message += product.toString();
        }
        return message;
    }
    
}


class Product{
    private int product_id;
    private String product_name;
    private double product_price;

    public Product(int pid, String name, double price){
        this.product_id = pid;
        this.product_name = name;
        this.product_price = price;
    }
    
    public double getPrice(){
        return this.product_price;
    }
    
    @Override
    public String toString(){
         return "Product{ID="+this.product_id+", name='" + this.product_name + "', price=" + this.product_price + "}\n";
    }
}