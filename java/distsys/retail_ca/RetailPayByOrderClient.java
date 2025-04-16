/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.jmdns.ServiceEvent;
import java.io.IOException;

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
    
    private RetailPayByOrderServiceStub asyncStub;
    private RetailPayByOrderServiceBlockingStub syncStub;
    private static final String API_KEY = "HJYew6Tm1ry6we6K5PLnFfj4qjsVXZ0Y";
    
    public RetailPayByOrderClient(){
        try{
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener("_grpc._tcp.local.", new ServiceListener(){
                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: "+event.getName());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: "+event.getName());
                }
                
                @Override
                public void serviceResolved(ServiceEvent event){
                    if(!event.getName().equals("RetailPayByOrderServiceGrpc")){
                        // other Service
                        return;
                    }
                    ServiceInfo info = event.getInfo();
                    String host = info.getHostAddresses()[0];
                    int port = info.getPort();
                    System.out.println("Discovered RetailPayByOrderServiceGrpc at "+host+ ":"+port);
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
                    ApiKeyCredential credentials = new ApiKeyCredential(API_KEY);
                    asyncStub = RetailPayByOrderServiceGrpc.newStub(channel).withCallCredentials(credentials);
                    syncStub = RetailPayByOrderServiceGrpc.newBlockingStub(channel).withCallCredentials(credentials);
                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }
//        int port = 50052;
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
//        asyncStub = RetailPayByOrderServiceGrpc.newStub(channel);
//        syncStub = RetailPayByOrderServiceGrpc.newBlockingStub(channel);
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
