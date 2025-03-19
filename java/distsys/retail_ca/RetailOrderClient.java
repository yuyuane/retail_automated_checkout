/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import generated.grpc.retailorderservice.RetailOrderServiceGrpc;
import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceBlockingStub;
import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceStub;

/**
 *
 * @author yuyua
 */
public class RetailOrderClient {
    
    private static RetailOrderServiceStub asyncStub;
    private static RetailOrderServiceBlockingStub syncStub;
    
    public static void main(String[] args) {
        int port = 50051;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        asyncStub = RetailOrderServiceGrpc.newStub(channel);
        syncStub = RetailOrderServiceGrpc.newBlockingStub(channel);
        requestAddOrderByProductIds();
        getProductsByOrderNo();
    }
    
    /**
     * Need to execute the AddOrderByProductIds
     */
    private static void requestAddOrderByProductIds(){
        
    }
    
    private static void  getProductsByOrderNo(){
        
    }
    
    
    
    
}
