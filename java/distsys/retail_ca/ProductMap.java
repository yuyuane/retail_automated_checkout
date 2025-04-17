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
       Product chips = new Product(1,"chips",2.2);
       productList.put("chips", chips);
       Product nuts = new Product(2,"nuts",4.0);
       productList.put("nuts", nuts);
       Product candy = new Product(3,"candy",1.1);
       productList.put("candy", candy);
       Product cookies = new Product(4,"cookies",1.39);
       productList.put("cookies", cookies);
       Product apple = new Product(5,"apple",1.0);
       productList.put("apple", apple);
       Product orange = new Product(6,"orange",2.29);
       productList.put("orange", orange);
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
    private int productId;
    private String productName;
    private double productPrice;

    public Product(int pid, String name, double price){
        this.productId = pid;
        this.productName = name;
        this.productPrice = price;
    }
    
    public int getProductId(){
        return this.productId;
    }
    
    public String getName(){
        return this.productName;
    }
    
    public double getPrice(){
        return this.productPrice;
    }
    
    @Override
    public String toString(){
         return "Product{ID="+this.productId+", name='" + this.productName + "', price=" + this.productPrice + "}\n";
    }
}