/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.jmdns.ServiceEvent;
import java.io.IOException;

import generated.grpc.retailorderservice.RetailOrderServiceGrpc;
import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceBlockingStub;
import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceStub;
import generated.grpc.retailorderservice.Order;
import generated.grpc.retailorderservice.Product;

/**
 *
 * @author yuyua
 */
public class RetailOrderClient {
    
    public RetailOrderServiceStub asyncStub;
    public RetailOrderServiceBlockingStub syncStub;
    private static final String API_KEY = "HJYew6Tm1ry6we6K5PLnFfj4qjsVXZ0Y";
    
    public RetailOrderClient(){
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
                    if(!event.getName().equals("RetailOrderServiceGrpc")){
                        // other Service
                        return;
                    }
                    ServiceInfo info = event.getInfo();
                    String host = info.getHostAddresses()[0];
                    int port = info.getPort();
                    System.out.println("Discovered RetailOrderServiceGrpc at "+host+":"+port);
                    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
                    ApiKeyCredential credentials = new ApiKeyCredential(API_KEY);
                    asyncStub = RetailOrderServiceGrpc.newStub(channel).withCallCredentials(credentials);
                    syncStub = RetailOrderServiceGrpc.newBlockingStub(channel).withCallCredentials(credentials);
                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
//        int port = 50051;
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
//        asyncStub = RetailOrderServiceGrpc.newStub(channel);
//        syncStub = RetailOrderServiceGrpc.newBlockingStub(channel);
//        requestAddOrderByProducts();
//        getProductsByOrderNo();
    }
    
    /**
     * Need to execute the AddOrderByProductIds
     * Get the parameter to service and handle logic
     */
    public void requestAddOrderByProducts(){
	 	System.out.println("Client Streaming Asynchronous - requestAddOrderByProducts of RetailOrder ");
        //get response
        StreamObserver<Order> responseObserver = new StreamObserver<Order>(){
            @Override
            public void onNext(Order order){
                //accept the orderNo
                System.out.println("RetailOrderService has return the orderNo: "+order.getOrderNo());
            }

            @Override
            public void onError(Throwable t){
                t.printStackTrace();
            }
            
            @Override            
            public void onCompleted(){
                System.out.println("This RetailOrderService is Completed!");
            }
        };
        //get request
        StreamObserver<Product> requestObserver = asyncStub.addOrderByProducts(responseObserver);
        //set productname as parameter 
        try{
            requestObserver.onNext(Product.newBuilder().setProductName("chips").build());
            Thread.sleep(500);
            requestObserver.onNext(Product.newBuilder().setProductName("strawberry").build());
            Thread.sleep(500);
            requestObserver.onNext(Product.newBuilder().setProductName("milk").build());
            Thread.sleep(500);
            requestObserver.onNext(Product.newBuilder().setProductName("orange").build());
            Thread.sleep(500);
            requestObserver.onCompleted();
            Thread.sleep(10000);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void  getProductsByOrderNo(){
	 	System.out.println("Server Streaming Asynchronous - getProductsByOrderNo of RetailOrder");
        String orderNo = "orderNo_8455c095-1ac8-4b35-a9f7-6b6a6e146931";
        Order request = Order.newBuilder().setOrderNo(orderNo).build();
        StreamObserver<Product> response = new StreamObserver<Product>(){
           @Override
           public void onNext(Product p){
               //GET productId and productName
               System.out.println("Product{id="+p.getProductId()+", name="+p.getProductName()+";}");
           }
           
           @Override
           public void onError(Throwable t){
               t.printStackTrace();
           }
           
           @Override
           public void onCompleted(){
               System.out.println("This RetailOrderService is Completed!");
           }
       };
       asyncStub.getProductsByOrderNo(request, response);
       try{
            Thread.sleep(1000);
       }catch(Exception e){
            e.printStackTrace();
       }
    }
    
    
    
    
}
