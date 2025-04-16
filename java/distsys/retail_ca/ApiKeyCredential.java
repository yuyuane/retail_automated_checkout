/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.retail_ca;
import io.grpc.CallCredentials;
import java.util.concurrent.Executor;
import io.grpc.Metadata;
import io.grpc.Status;

/**
 *
 * @author yuyua
 */
public class ApiKeyCredential extends CallCredentials {
    private final String apiKey;
    public ApiKeyCredential(String apiKey) {
        this.apiKey = apiKey;
    }
    @Override
    public void applyRequestMetadata(RequestInfo requestInfo,Executor executor,MetadataApplier metadataApplier){
        executor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                // 将 API Key 放入 Metadata 的 Header 中
                headers.put(Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER), apiKey);
                metadataApplier.apply(headers);
            } catch (Throwable e) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }
}
