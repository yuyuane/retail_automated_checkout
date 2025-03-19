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

import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceImplBase;
import generated.grpc.retailorderservice.Product;
import generated.grpc.retailorderservice.Order;
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
            server.awaitTermination();
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    @Override
    public StreamObserver<Product> addOrderByProducts(StreamObserver<Order> responseObserver){
        return new StreamObserver<Product>(){
            
            @Override
            public void onNext(Product request){
                //写逻辑
            }
            
            @Override
            public void onError(Throwable t){
                //错误处理
            }
            
            @Override
            public void onCompleted() {
                //写返回
            }
            
            
        };
    }
    
    @Override
    public void getProductsByOrderNo(Order request, StreamObserver<Product> response){
//        response.onNext(Product); 
// 获取出每一个产品。onNext加入到response中
    }
}
