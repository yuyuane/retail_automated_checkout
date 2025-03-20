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
//        String[] names = new String[]{"milk","chips"};
        ArrayList<String> names = new ArrayList<>();
        names.add("milk");
        ordermap.addOrderByProducts(names);
        System.out.println(ordermap.toString());
    }
    
    public OrderMap(){
        orderList = new HashMap<>();
        this.initOrder();
    }
    
    public void initOrder(){
        //set a order list
        String orderNo = "orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e146931";
        ProductMap productMap = new ProductMap();
        List<Product> products = new ArrayList<>();
        double orderAmount = 0;
        for(Product product: productMap.productList.values()){
            String name = product.getName(); 
            //add product to products of order
            products.add(product);
            orderAmount += product.getPrice();
        }
        String orderStatus = "unpaid";
        orderAmount = (new BigDecimal(orderAmount).setScale(2, RoundingMode.DOWN)).doubleValue();
        Order order = new Order(orderNo,orderStatus,orderAmount,products);
        orderList.put(orderNo,order);
    }
    
    public String addOrderByProducts(ArrayList<String> names){
        String orderNo = createOrderNo();
        ProductMap productAll = new ProductMap();
        List<Product> products = new ArrayList<>();
        double orderAmount = 0;
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            //get the corresponding product based on the product_name
            Product product = productAll.getProduct(name);
            //add product to products of order
            products.add(product);
            orderAmount += product.getPrice();
        }
        
        String orderStatus = "unpaid";
        // keep 2 decimal places
        orderAmount = (new BigDecimal(orderAmount).setScale(2, RoundingMode.DOWN)).doubleValue();
        Order order = new Order(orderNo,orderStatus,orderAmount,products);
        orderList.put(orderNo,order);
        return orderNo;
    }
    
    private String createOrderNo(){
        UUID uuid = UUID.randomUUID();
        return "orderNo_"+uuid.toString();
    }
    
    public Order getOrderByOrderNo(String orderNo){
        return orderList.get(orderNo);
    }
    
    public List<Product> getProductsByOrderNo(String orderNo){
        Order order = orderList.get(orderNo);
        if(order == null){
            return null;
        }
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
    private String orderNo;
    private String orderStatus;
    private double orderAmount;
    private List<Product> products;
    
    public Order(String no, String status, double amount, List<Product> products){
        this.orderNo = no;
        //paid unpaid
        this.orderStatus = status;
        this.orderAmount = amount;
        this.products = products;
    }
    
    public String getStatus(){
        return this.orderStatus;
    }
    
    public void setStatus(String status){
        this.orderStatus=status;
    }
    
    public List<Product> getProduct(){
        return this.products;
    }
    
    @Override
    public String toString(){
        return "Order{order_no='"+this.orderNo+"', order_status='"+this.orderStatus+"', order_amount="+this.orderAmount+", products="+this.products.toString()+"}\n";
    }
}
