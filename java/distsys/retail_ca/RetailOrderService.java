/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ServerBuilder;
import java.util.logging.Logger;
import java.io.IOException;
import io.grpc.Server;

import generated.grpc.retailorderservice.RetailOrderServiceGrpc.RetailOrderServiceImplBase;
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
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public AddOrderByProductIds(){
    }
}
