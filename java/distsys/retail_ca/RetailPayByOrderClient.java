/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceGrpc;
import generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceGrpc.RetailPayByOrderServiceBlockingStub;
import generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceGrpc.RetailPayByOrderServiceStub;
import generated.grpc.retailpaybyorderservice.Order;
import generated.grpc.retailpaybyorderservice.Payment;

/**
 *
 * @author yuyua
 */
public class RetailPayByOrderClient {
    
    private static RetailPayByOrderServiceStub asyncStub;
    private static RetailPayByOrderServiceBlockingStub syncStub;
    
    public RetailPayByOrderClient(){
        int port = 50052;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        asyncStub = RetailPayByOrderServiceGrpc.newStub(channel);
        syncStub = RetailPayByOrderServiceGrpc.newBlockingStub(channel);
    }
    public String requestPayByOrderId(String orderId){
        System.out.println("Unary - requestPayByOrderId of RetailPayByOrder");
        // orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e146931
//        String orderId = "orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e146931";
        Order order = Order.newBuilder().setOrderNo(orderId).build();
        Payment response = syncStub.payByOrderId(order);
        return "Receied the newest paymentNo is "+response.getPayNo();
//        System.out.println("Receied the newest paymentNo is "+response.getPayNo());
    
    }
    
    public String getPaymentInfoByOrderNo(String orderId){
	System.out.println("Unary - getPaymentInfoByOrderNo of RetailPayByOrder");
        // orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e1469312
//        String orderId = "orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e1469312";
        Order order = Order.newBuilder().setOrderNo(orderId).build();
        Payment response = syncStub.getPaymentInfoByOrderNo(order);
        return "paymentInfo{paymentNo="+response.getPayNo()+", paymentStatus="+response.getPStatus()+"}";
//        System.out.println("Receied! paymentInfo{paymentNo="+response.getPayNo()+", paymentStatus="+response.getPStatus()+"}");
    }
    
}
