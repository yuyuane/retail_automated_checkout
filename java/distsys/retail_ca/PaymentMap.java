/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;
import java.util.HashMap;
import java.util.UUID;
/**
 *
 * @author yuyua
 */
public class PaymentMap {
    HashMap<String,Payment> paymentList;
    String message;
    public PaymentMap(){
        paymentList = new HashMap<>();
        this.initPayment();
        
    }
    
    public void initPayment(){
        String paymentNo = "payNo_ac8-4b35-a9f7-6b6a6e1469312";
        Payment payment = new Payment(paymentNo,"orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e1469312","paid");
        paymentList.put(paymentNo,payment);
    }
    
    public String pay(String orderNo){
        //修改订单状态，输出payment_no 输入支付状态[未支付],
        //check whether this order with orderNo exists in the paymentList;
        OrderMap orderMap = new OrderMap();
        Order order = orderMap.getOrderByOrderNo(orderNo);
        System.out.println(1+""+order);
        //Didn't find the order
        if(order == null)return null;
        //The order has been paid!
        System.out.println("paid");
        if(order.getStatus().equals("paid")) return null;
        Payment payment = getPaymentByOrderNo(orderNo);
        String paymentNo;
        System.out.println(2+""+payment);
        if(payment == null){
            paymentNo = createPayNo();
            String status= "paid";
            //Update order payment status
            order.setStatus(status);
            payment = new Payment(paymentNo, orderNo, status);
            paymentList.put(paymentNo,payment);
        }else{
            paymentNo = payment.getPaymentNo();
        }
        return paymentNo;        
    }
    
    
    private String createPayNo(){
        UUID uuid = UUID.randomUUID();
        return "payNo_"+uuid.toString();
    }
    
    //order_status remember to udpate!!!!
    public void pay(String orderNo, String status){
    
    }
    
    public Payment getPaymentByOrderNo(String orderNo){
        //根据order_no获取对应的支付信息
        //Based on the orderNo, get the  payment information
        if(paymentList.size()==0){
            return null;
        }
        for (Payment payment:paymentList.values()) {
            if(payment.getOrderNo().equals(orderNo)){
                return payment;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        for(Payment payment: paymentList.values()){
            message += payment.toString();
        }
        return message;
    }
}

class Payment{
    private String paymentNo;
    private String paymentStatus;
    private String orderNo;
    public Payment(String no, String orderNo, String status){
        this.paymentNo = no;
        this.orderNo = orderNo;
        this.paymentStatus = status;
    }
    
    public String getOrderNo(){
        return this.orderNo;
    }
    
    public String getPaymentNo(){
        return this.paymentNo;
    }
    
    public String getPaymentStatus(){
        return this.paymentStatus;
    }
    
    @Override
    public String toString(){
        return "Payment{No="+this.paymentNo+",orderNo="+this.orderNo+", Status="+this.paymentStatus+"}\n";
    }
}