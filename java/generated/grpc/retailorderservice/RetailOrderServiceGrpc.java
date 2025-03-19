package generated.grpc.retailorderservice;

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
    comments = "Source: RetailOrderService.proto")
public final class RetailOrderServiceGrpc {

  private RetailOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "RetailOrderService.RetailOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Product,
      generated.grpc.retailorderservice.Order> getAddOrderByProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddOrderByProducts",
      requestType = generated.grpc.retailorderservice.Product.class,
      responseType = generated.grpc.retailorderservice.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Product,
      generated.grpc.retailorderservice.Order> getAddOrderByProductsMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Product, generated.grpc.retailorderservice.Order> getAddOrderByProductsMethod;
    if ((getAddOrderByProductsMethod = RetailOrderServiceGrpc.getAddOrderByProductsMethod) == null) {
      synchronized (RetailOrderServiceGrpc.class) {
        if ((getAddOrderByProductsMethod = RetailOrderServiceGrpc.getAddOrderByProductsMethod) == null) {
          RetailOrderServiceGrpc.getAddOrderByProductsMethod = getAddOrderByProductsMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailorderservice.Product, generated.grpc.retailorderservice.Order>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RetailOrderService.RetailOrderService", "AddOrderByProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailorderservice.Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailorderservice.Order.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailOrderServiceMethodDescriptorSupplier("AddOrderByProducts"))
                  .build();
          }
        }
     }
     return getAddOrderByProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Order,
      generated.grpc.retailorderservice.Product> getGetProductsByOrderNoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProductsByOrderNo",
      requestType = generated.grpc.retailorderservice.Order.class,
      responseType = generated.grpc.retailorderservice.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Order,
      generated.grpc.retailorderservice.Product> getGetProductsByOrderNoMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailorderservice.Order, generated.grpc.retailorderservice.Product> getGetProductsByOrderNoMethod;
    if ((getGetProductsByOrderNoMethod = RetailOrderServiceGrpc.getGetProductsByOrderNoMethod) == null) {
      synchronized (RetailOrderServiceGrpc.class) {
        if ((getGetProductsByOrderNoMethod = RetailOrderServiceGrpc.getGetProductsByOrderNoMethod) == null) {
          RetailOrderServiceGrpc.getGetProductsByOrderNoMethod = getGetProductsByOrderNoMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailorderservice.Order, generated.grpc.retailorderservice.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RetailOrderService.RetailOrderService", "GetProductsByOrderNo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailorderservice.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailorderservice.Product.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailOrderServiceMethodDescriptorSupplier("GetProductsByOrderNo"))
                  .build();
          }
        }
     }
     return getGetProductsByOrderNoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RetailOrderServiceStub newStub(io.grpc.Channel channel) {
    return new RetailOrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RetailOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RetailOrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RetailOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RetailOrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RetailOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Product> addOrderByProducts(
        io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Order> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddOrderByProductsMethod(), responseObserver);
    }

    /**
     */
    public void getProductsByOrderNo(generated.grpc.retailorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductsByOrderNoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddOrderByProductsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.retailorderservice.Product,
                generated.grpc.retailorderservice.Order>(
                  this, METHODID_ADD_ORDER_BY_PRODUCTS)))
          .addMethod(
            getGetProductsByOrderNoMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.retailorderservice.Order,
                generated.grpc.retailorderservice.Product>(
                  this, METHODID_GET_PRODUCTS_BY_ORDER_NO)))
          .build();
    }
  }

  /**
   */
  public static final class RetailOrderServiceStub extends io.grpc.stub.AbstractStub<RetailOrderServiceStub> {
    private RetailOrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Product> addOrderByProducts(
        io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Order> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAddOrderByProductsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getProductsByOrderNo(generated.grpc.retailorderservice.Order request,
        io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Product> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetProductsByOrderNoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RetailOrderServiceBlockingStub extends io.grpc.stub.AbstractStub<RetailOrderServiceBlockingStub> {
    private RetailOrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<generated.grpc.retailorderservice.Product> getProductsByOrderNo(
        generated.grpc.retailorderservice.Order request) {
      return blockingServerStreamingCall(
          getChannel(), getGetProductsByOrderNoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RetailOrderServiceFutureStub extends io.grpc.stub.AbstractStub<RetailOrderServiceFutureStub> {
    private RetailOrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOrderServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_PRODUCTS_BY_ORDER_NO = 0;
  private static final int METHODID_ADD_ORDER_BY_PRODUCTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RetailOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RetailOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCTS_BY_ORDER_NO:
          serviceImpl.getProductsByOrderNo((generated.grpc.retailorderservice.Order) request,
              (io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Product>) responseObserver);
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
        case METHODID_ADD_ORDER_BY_PRODUCTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addOrderByProducts(
              (io.grpc.stub.StreamObserver<generated.grpc.retailorderservice.Order>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RetailOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RetailOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.retailorderservice.RetailOrderServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RetailOrderService");
    }
  }

  private static final class RetailOrderServiceFileDescriptorSupplier
      extends RetailOrderServiceBaseDescriptorSupplier {
    RetailOrderServiceFileDescriptorSupplier() {}
  }

  private static final class RetailOrderServiceMethodDescriptorSupplier
      extends RetailOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RetailOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RetailOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RetailOrderServiceFileDescriptorSupplier())
              .addMethod(getAddOrderByProductsMethod())
              .addMethod(getGetProductsByOrderNoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
