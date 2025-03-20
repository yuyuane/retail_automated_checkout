/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ServerBuilder;
import java.util.logging.Logger;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import generated.grpc.retailopendoorservice.RetailOpenDoorServiceGrpc.RetailOpenDoorServiceImplBase;
import generated.grpc.retailopendoorservice.Door;
import generated.grpc.retailopendoorservice.Payment;

/**
 *
 * @author yuyua
 */
public class RetailOpenDoorService extends RetailOpenDoorServiceImplBase {
    private static final Logger logger = Logger.getLogger(RetailOpenDoorService.class.getName());
    /**
     * This is the third step Service
     * @param args 
     */
    public static void main(String[] args) {
        int port = 50053;
        RetailOpenDoorService orderService = new RetailOpenDoorService();
        try {
            Server server = ServerBuilder.forPort(port).addService(orderService).build().start();
            logger.info("The third step Server started, listening on the port "+port);
            System.out.println("The third step Server started, listening on the port "+port);
            server.awaitTermination();
        } catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public StreamObserver<Payment> currentDoorStatus(StreamObserver<Door> responseObserver){
        return new StreamObserver<Payment>(){
            DoorMap doorMap = new DoorMap();
            @Override
            public void onNext(Payment request){
                String paymentNo = request.getPayNo();
                //get doorInfo based on payNo
                System.out.println("doorMap.getDoorByPaymentNo--"+paymentNo);
                distsys.retail_ca.Door doorInfo = doorMap.getDoorByPaymentNo(paymentNo);
                Door reply = Door.newBuilder().setDoorNo(doorInfo.getDoorNo()).setDStatus(doorInfo.getStatus()).build();
                responseObserver.onNext(reply);
            }
            @Override
            public void onError(Throwable t){
                t.printStackTrace();
            }
            @Override
            public void onCompleted(){
                responseObserver.onCompleted();
            }
        };
    }
    
    @Override
    public void openDoor(Payment request, StreamObserver<Door> response){
        //讲多个数据加入到 response.onNext(door); get doorNo paymentNo
        //check whether the door is working
        int doorNo = request.getDoorNo();
        String payNo = request.getPayNo();
        DoorMap doorMap = new DoorMap();
        distsys.retail_ca.Door doorInfo = doorMap.getDoorByDoorNo(doorNo);
        if(doorInfo.getStatus().equals("open")){
            System.out.println("Please contact our staff!");
            return;
        }
        distsys.retail_ca.Door doorInfo2 = doorMap.getDoorByPaymentNo(payNo);
        if(doorInfo2 != null && doorInfo2.getStatus().equals("open")){
            System.out.println("Please contact our staff!");
            return;
        }
        doorMap.updateDoorStatusByDoorNo(doorNo,"open",payNo);
        Door door = Door.newBuilder().setDStatus("open").setDoorNo(doorNo).build();
        response.onNext(door);
        response.onCompleted();
    }
}
