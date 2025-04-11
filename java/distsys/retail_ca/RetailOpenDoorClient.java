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
import io.grpc.stub.StreamObserver;
import generated.grpc.retailopendoorservice.Door;
import generated.grpc.retailopendoorservice.Payment;

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
        getAllCurrentDoorStatus();
        requestOpenDoor();
    }
    
    public static void getAllCurrentDoorStatus(){
        System.out.println("Bi-directional - getCurrentDoorStatus of RetailOpenDoor");
        StreamObserver<Door> responseObserver = new StreamObserver<Door>(){
            @Override
            public void onNext(Door d){
                System.out.println("Door{doorNo="+d.getDoorNo()+", doorStatus= "+d.getDStatus()+"}");
            }
            @Override
            public void onError(Throwable t){
                t.printStackTrace();
            }
            
            @Override
            public void onCompleted(){
                System.out.println("Bi-directional - getCurrentDoorStatus of RetailOpenDoor is completed!");
            }
        };
        
        StreamObserver<Payment> request = asyncStub.currentDoorStatus(responseObserver);
        try{
            request.onNext(Payment.newBuilder().setPayNo("payNo_ac8-4b35-a9f7-6b6a6e1469311").build());
            Thread.sleep(500);
            request.onNext(Payment.newBuilder().setPayNo("payNo_ac8-4b35-a9f7-6b6a6e1469312").build());
            Thread.sleep(500);
            request.onCompleted();
            Thread.sleep(5000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void requestOpenDoor(){
        System.out.println("Unary - requestOpenDoor of RetailOpenDoor");
        //input doorNo
        int doorNo = 1;
        String paymentNo = "payNo_ac8-4b35-a9f7-6b6a6e1469300";
        Payment payment = Payment.newBuilder().setDoorNo(doorNo).setPayNo(paymentNo).build();
        Door response = syncStub.openDoor(payment);
        System.out.println("Receied! The door of number "+doorNo+" is "+response.getDStatus()+", Welcome again!");
    }
}
