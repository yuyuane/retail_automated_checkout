/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;

import io.grpc.ServerBuilder;
import java.util.logging.Logger;
import java.io.IOException;
import io.grpc.Server;

import generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceGrpc.RetailPayByOrderServiceImplBase;

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
            server.awaitTermination();
        } catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
