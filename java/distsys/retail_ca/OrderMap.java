/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author yuyua
 */
public class OrderMap {
    HashMap<String,Order> orderList;
    String message;
    public static void main(String[] args) {
        OrderMap ordermap = new OrderMap();
        String[] names = new String[]{"milk","chips"};
        ordermap.addOrderByProducts(names);
        System.out.println(ordermap.toString());
    }
    
    public OrderMap(){
        orderList = new HashMap<>();
    }
    public void addOrderByProducts(String[] names){
        String order_no = getOrderNo();
        ProductMap productAll = new ProductMap();
        List<Product> products = new ArrayList<>();
        double order_amount = 0;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            //get the corresponding product based on the product_name
            Product product = productAll.getProduct(name);
            //add product to products of order
            products.add(product);
            order_amount += product.getPrice();
        }
        
        String order_status = "unpaid";
        // keep 2 decimal places
        order_amount = (new BigDecimal(order_amount).setScale(2, RoundingMode.DOWN)).doubleValue();
        Order order = new Order(order_no,order_status,order_amount,products);
        orderList.put(order_no,order);
    }
    
    private String getOrderNo(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    public Order getOrderByOrderNo(String orderNo){
        return orderList.get(orderNo);
    }
    
    public List<Product> getProductsByOrderNo(String orderNo){
        Order order = orderList.get(orderNo);
        return order.getProduct();
    }
    
    @Override
    public String toString(){
        for (Order order: orderList.values()) {
            message += order.toString();
        }
        return message;
    }
}

class Order{
    private String order_no;
    private String order_status;
    private double order_amount;
    private List<Product> products;
    
    public Order(String no, String status, double amount, List<Product> products){
        this.order_no = no;
        this.order_status = status;
        this.order_amount = amount;
        this.products = products;
    }
    
    public List<Product> getProduct(){
        return this.products;
    }
    
    @Override
    public String toString(){
        return "Order{order_no='"+this.order_no+"', order_status='"+this.order_status+"', order_amount="+this.order_amount+", products="+this.products.toString()+"}\n";
    }
}
