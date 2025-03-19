/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import generated.grpc.retailopendoorservice.RetailOpenDoorServiceGrpc;
import generated.grpc.retailopendoorservice.RetailOpenDoorServiceGrpc.RetailOpenDoorServiceBlockingStub;
import generated.grpc.retailopendoorservice.RetailOpenDoorServiceGrpc.RetailOpenDoorServiceStub;

/**
 *
 * @author yuyua
 */
public class RetailOpenDoorClient {
    private static RetailOpenDoorServiceStub asyncStub;
    private static RetailOpenDoorServiceBlockingStub syncStub;
    
    public static void main(String[] args) {
        int port = 50053;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        syncStub = RetailOpenDoorServiceGrpc.newBlockingStub(channel);
        asyncStub = RetailOpenDoorServiceGrpc.newStub(channel);
        getCurrentDoorStatus();
        requestOpenDoor();
    }
    
    private static void getCurrentDoorStatus(){
    
    }
    
    private static void requestOpenDoor(){
    
    }
}
