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
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceGrpc.RetailPayByOrderServiceImplBase;
import generated.grpc.retailpaybyorderservice.Order;
import generated.grpc.retailpaybyorderservice.Payment;

/**
 *
 * @author yuyua
 */
public class RetailPayByOrderService extends RetailPayByOrderServiceImplBase {
    private static final Logger logger = Logger.getLogger(RetailPayByOrderService.class.getName());
    /**
     * This is the second step Service
     * @param args 
     */
    public static void main(String[] args) {
        int port = 50052;
        RetailPayByOrderService orderService = new RetailPayByOrderService();
        try {
            Server server = ServerBuilder.forPort(port).addService(orderService).build().start();
            logger.info("The second step Server started, listening on the port "+port);
            System.out.println("The second step Server started, listening on the port "+port);
            // register Service
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "RetailPayByOrderService", 50052, "desc=Pay's gRPC service");
            jmdns.registerService(serviceInfo);
            new Thread(() -> {
                try {
                    server.awaitTermination(); // 阻塞在新线程中
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void payByOrderId(Order request,StreamObserver<Payment> response){
        // response.onNext(Payment);
       PaymentMap paymentMap = new PaymentMap();
       String paymentNo = paymentMap.pay(request.getOrderNo());
       if(paymentNo == null){
            System.out.println("Please check whether this OrderNo is wrong!");
            return;
       }
       Payment payment = Payment.newBuilder().setPayNo(paymentNo).build();
       response.onNext(payment);
       response.onCompleted();
    }
    
    @Override
    public void getPaymentInfoByOrderNo(Order request,StreamObserver<Payment> response){
        // response.onNext(Payment);
        PaymentMap paymentMap = new PaymentMap();
        distsys.retail_ca.Payment paymentInfo = paymentMap.getPaymentByOrderNo(request.getOrderNo());
        if(paymentInfo == null){
            System.out.println("Please check whether this OrderNo is wrong!");
            return;
        }
        Payment payment = Payment.newBuilder().setPayNo(paymentInfo.getPaymentNo()).setPStatus(paymentInfo.getPaymentStatus()).build();
        response.onNext(payment);
        response.onCompleted();
    }
}
