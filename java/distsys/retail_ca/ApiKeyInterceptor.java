/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;
import io.grpc.ServerInterceptor;
import io.grpc.ServerCall;
import io.grpc.Metadata;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

/**
 *
 * @author yuyua
 */
public class ApiKeyInterceptor implements ServerInterceptor {
    private static final String API_KEY = "HJYew6Tm1ry6we6K5PLnFfj4qjsVXZ0Y";
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,ServerCallHandler<ReqT, RespT> next){
        String clientApiKey = headers.get(Metadata.Key.of("api-key",Metadata.ASCII_STRING_MARSHALLER));
        if(clientApiKey == null && !clientApiKey.equals(API_KEY)){
            call.close(Status.UNAUTHENTICATED.withDescription("API Key is wrong!"), headers);
            return new ServerCall.Listener<ReqT>(){};
        }
        return next.startCall(call, headers);
    }   
}
