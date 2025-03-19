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

/**
 *
 * @author yuyua
 */
public class RetailPayByOrderClient {
    
    private static RetailPayByOrderServiceStub asyncStub;
    private static RetailPayByOrderServiceBlockingStub syncStub;
    
    public static void main(String[] args) {
        int port = 50052;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        asyncStub = RetailPayByOrderServiceGrpc.newStub(channel);
        syncStub = RetailPayByOrderServiceGrpc.newBlockingStub(channel);
        requestPayByOrderId();
        getPaymentInfoByOrderNo();        
    }
    
    private static void requestPayByOrderId(){
    
    }
    private static void getPaymentInfoByOrderNo(){
        
    }
    
}
