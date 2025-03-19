package generated.grpc.retailpaybyorderservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: RetailPayOrderService.proto")
public final class RetailPayByOrderServiceGrpc {

  private RetailPayByOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "RetailPayByOrderService.RetailPayByOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order,
      generated.grpc.retailpaybyorderservice.Payment> getPayByOrderIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PayByOrderId",
      requestType = generated.grpc.retailpaybyorderservice.Order.class,
      responseType = generated.grpc.retailpaybyorderservice.Payment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order,
      generated.grpc.retailpaybyorderservice.Payment> getPayByOrderIdMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order, generated.grpc.retailpaybyorderservice.Payment> getPayByOrderIdMethod;
    if ((getPayByOrderIdMethod = RetailPayByOrderServiceGrpc.getPayByOrderIdMethod) == null) {
      synchronized (RetailPayByOrderServiceGrpc.class) {
        if ((getPayByOrderIdMethod = RetailPayByOrderServiceGrpc.getPayByOrderIdMethod) == null) {
          RetailPayByOrderServiceGrpc.getPayByOrderIdMethod = getPayByOrderIdMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailpaybyorderservice.Order, generated.grpc.retailpaybyorderservice.Payment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RetailPayByOrderService.RetailPayByOrderService", "PayByOrderId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailpaybyorderservice.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailpaybyorderservice.Payment.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailPayByOrderServiceMethodDescriptorSupplier("PayByOrderId"))
                  .build();
          }
        }
     }
     return getPayByOrderIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order,
      generated.grpc.retailpaybyorderservice.Payment> getGetPaymentInfoByOrderNoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPaymentInfoByOrderNo",
      requestType = generated.grpc.retailpaybyorderservice.Order.class,
      responseType = generated.grpc.retailpaybyorderservice.Payment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order,
      generated.grpc.retailpaybyorderservice.Payment> getGetPaymentInfoByOrderNoMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailpaybyorderservice.Order, generated.grpc.retailpaybyorderservice.Payment> getGetPaymentInfoByOrderNoMethod;
    if ((getGetPaymentInfoByOrderNoMethod = RetailPayByOrderServiceGrpc.getGetPaymentInfoByOrderNoMethod) == null) {
      synchronized (RetailPayByOrderServiceGrpc.class) {
        if ((getGetPaymentInfoByOrderNoMethod = RetailPayByOrderServiceGrpc.getGetPaymentInfoByOrderNoMethod) == null) {
          RetailPayByOrderServiceGrpc.getGetPaymentInfoByOrderNoMethod = getGetPaymentInfoByOrderNoMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailpaybyorderservice.Order, generated.grpc.retailpaybyorderservice.Payment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RetailPayByOrderService.RetailPayByOrderService", "GetPaymentInfoByOrderNo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailpaybyorderservice.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailpaybyorderservice.Payment.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailPayByOrderServiceMethodDescriptorSupplier("GetPaymentInfoByOrderNo"))
                  .build();
          }
        }
     }
     return getGetPaymentInfoByOrderNoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RetailPayByOrderServiceStub newStub(io.grpc.Channel channel) {
    return new RetailPayByOrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RetailPayByOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RetailPayByOrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RetailPayByOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RetailPayByOrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RetailPayByOrderServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * create payment record
     * </pre>
     */
    public void payByOrderId(generated.grpc.retailpaybyorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment> responseObserver) {
      asyncUnimplementedUnaryCall(getPayByOrderIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get payment record
     * </pre>
     */
    public void getPaymentInfoByOrderNo(generated.grpc.retailpaybyorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPaymentInfoByOrderNoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPayByOrderIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.retailpaybyorderservice.Order,
                generated.grpc.retailpaybyorderservice.Payment>(
                  this, METHODID_PAY_BY_ORDER_ID)))
          .addMethod(
            getGetPaymentInfoByOrderNoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.retailpaybyorderservice.Order,
                generated.grpc.retailpaybyorderservice.Payment>(
                  this, METHODID_GET_PAYMENT_INFO_BY_ORDER_NO)))
          .build();
    }
  }

  /**
   */
  public static final class RetailPayByOrderServiceStub extends io.grpc.stub.AbstractStub<RetailPayByOrderServiceStub> {
    private RetailPayByOrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailPayByOrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailPayByOrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailPayByOrderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * create payment record
     * </pre>
     */
    public void payByOrderId(generated.grpc.retailpaybyorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPayByOrderIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get payment record
     * </pre>
     */
    public void getPaymentInfoByOrderNo(generated.grpc.retailpaybyorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPaymentInfoByOrderNoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RetailPayByOrderServiceBlockingStub extends io.grpc.stub.AbstractStub<RetailPayByOrderServiceBlockingStub> {
    private RetailPayByOrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailPayByOrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailPayByOrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailPayByOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * create payment record
     * </pre>
     */
    public generated.grpc.retailpaybyorderservice.Payment payByOrderId(generated.grpc.retailpaybyorderservice.Order request) {
      return blockingUnaryCall(
          getChannel(), getPayByOrderIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get payment record
     * </pre>
     */
    public generated.grpc.retailpaybyorderservice.Payment getPaymentInfoByOrderNo(generated.grpc.retailpaybyorderservice.Order request) {
      return blockingUnaryCall(
          getChannel(), getGetPaymentInfoByOrderNoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RetailPayByOrderServiceFutureStub extends io.grpc.stub.AbstractStub<RetailPayByOrderServiceFutureStub> {
    private RetailPayByOrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailPayByOrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailPayByOrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailPayByOrderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * create payment record
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.retailpaybyorderservice.Payment> payByOrderId(
        generated.grpc.retailpaybyorderservice.Order request) {
      return futureUnaryCall(
          getChannel().newCall(getPayByOrderIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get payment record
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.retailpaybyorderservice.Payment> getPaymentInfoByOrderNo(
        generated.grpc.retailpaybyorderservice.Order request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPaymentInfoByOrderNoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PAY_BY_ORDER_ID = 0;
  private static final int METHODID_GET_PAYMENT_INFO_BY_ORDER_NO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RetailPayByOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RetailPayByOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PAY_BY_ORDER_ID:
          serviceImpl.payByOrderId((generated.grpc.retailpaybyorderservice.Order) request,
              (io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment>) responseObserver);
          break;
        case METHODID_GET_PAYMENT_INFO_BY_ORDER_NO:
          serviceImpl.getPaymentInfoByOrderNo((generated.grpc.retailpaybyorderservice.Order) request,
              (io.grpc.stub.StreamObserver<generated.grpc.retailpaybyorderservice.Payment>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RetailPayByOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RetailPayByOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.retailpaybyorderservice.RetailPayByOrderServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RetailPayByOrderService");
    }
  }

  private static final class RetailPayByOrderServiceFileDescriptorSupplier
      extends RetailPayByOrderServiceBaseDescriptorSupplier {
    RetailPayByOrderServiceFileDescriptorSupplier() {}
  }

  private static final class RetailPayByOrderServiceMethodDescriptorSupplier
      extends RetailPayByOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RetailPayByOrderServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RetailPayByOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RetailPayByOrderServiceFileDescriptorSupplier())
              .addMethod(getPayByOrderIdMethod())
              .addMethod(getGetPaymentInfoByOrderNoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
