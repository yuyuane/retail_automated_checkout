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
        
    }
    public Boolean addPaymentByOrderNo(String orderNo){
        //修改订单状态，输出payment_no 输入支付状态[未支付],
        //check whether this order with orderNo exists in the paymentList;
        Payment payment = getPaymentByOrderNo(orderNo);
        if(payment==null){
            return false;
        }
        String paymentNo = createPayNo();
        payment = new Payment(paymentNo, orderNo, "unpaid");
        paymentList.put(paymentNo,payment);
        return true;        
    }
    
    
    private String createPayNo(){
        UUID uuid = UUID.randomUUID();
        return "payNo_"+uuid.toString();
    }
    
    //输入支付状态，则为支付成功,先查询支付状态
    //order_status remember to udpate!!!!
    public void pay(String orderNo, String status){
    
    }
    
    public Payment getPaymentByOrderNo(String orderNo){
        //根据order_no获取对应的支付信息
        //Based on the orderNo, get the  payment information
        if(paymentList.size()==0){
            return null;
        }
        Payment payment = paymentList.get(orderNo);
        return payment;
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
    
    @Override
    public String toString(){
        return "Payment{No="+this.paymentNo+",orderNo="+this.orderNo+", Status="+this.paymentStatus+"}\n";
    }
}