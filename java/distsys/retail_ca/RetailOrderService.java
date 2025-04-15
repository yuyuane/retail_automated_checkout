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
import java.util.ArrayList;

import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceImplBase;
import generated.grpc.retailorderservice.Product;
import generated.grpc.retailorderservice.Order;
import java.util.List;
/**
 *
 * @author yuyua
 */
public class RetailOrderService extends RetailOrderServiceImplBase {
    private static final Logger logger = Logger.getLogger(RetailOrderService.class.getName());
    /**
     * This is the first step Service
     * @param args 
     */
    public static void main(String[] args) {
        RetailOrderService orderService = new RetailOrderService();
        int port = 50051;
        try {
            Server server = ServerBuilder.forPort(port).addService(orderService).build().start();
            logger.info("The first step Server started, listening on the port "+port);
            System.out.println("The first step Server started, listening on the port "+port);
            new Thread(()->{
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
    public StreamObserver<Product> addOrderByProducts(StreamObserver<Order> responseObserver){
        return new StreamObserver<Product>(){
            ArrayList<String> productNames = new ArrayList<>();
            
            @Override
            public void onNext(Product request){
                //accept the productName
               productNames.add(request.getProductName());
            }
            
            @Override
            public void onError(Throwable t){
                //错误处理
            }
            
            @Override
            public void onCompleted() {
                //call addorder function to create order
                OrderMap orderMap = new OrderMap();
                String orderNo = orderMap.addOrderByProducts(productNames);
                //输入订单ID 到reply
                Order reply = Order.newBuilder().setOrderNo(orderNo).build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
            
            
        };
    }
    
    @Override
    public void getProductsByOrderNo(Order request, StreamObserver<Product> response){
//        response.onNext(Product); 
// 获取出每一个产品。onNext加入到response中
        String orderNo = request.getOrderNo();
        OrderMap orderMap = new OrderMap();
        List<distsys.retail_ca.Product> products = orderMap.getProductsByOrderNo(orderNo);
        if(products != null){
            for (int i = 0; i < products.size(); i++) {
                distsys.retail_ca.Product obj = products.get(i);
                Product product = Product.newBuilder().setProductId(obj.getProductId()).setProductName(obj.getName()).build();
                response.onNext(product);
            }
            response.onCompleted();
        }else{
            System.out.println("Please Check whether the OrderNo is Wrong! ");
        }
        
    }
}
