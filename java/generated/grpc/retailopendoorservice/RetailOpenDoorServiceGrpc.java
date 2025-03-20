package generated.grpc.retailopendoorservice;

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
    comments = "Source: RetailOpenDoorService.proto")
public final class RetailOpenDoorServiceGrpc {

  private RetailOpenDoorServiceGrpc() {}

  public static final String SERVICE_NAME = "RetailOpenDoorService.RetailOpenDoorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment,
      generated.grpc.retailopendoorservice.Door> getCurrentDoorStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CurrentDoorStatus",
      requestType = generated.grpc.retailopendoorservice.Payment.class,
      responseType = generated.grpc.retailopendoorservice.Door.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment,
      generated.grpc.retailopendoorservice.Door> getCurrentDoorStatusMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment, generated.grpc.retailopendoorservice.Door> getCurrentDoorStatusMethod;
    if ((getCurrentDoorStatusMethod = RetailOpenDoorServiceGrpc.getCurrentDoorStatusMethod) == null) {
      synchronized (RetailOpenDoorServiceGrpc.class) {
        if ((getCurrentDoorStatusMethod = RetailOpenDoorServiceGrpc.getCurrentDoorStatusMethod) == null) {
          RetailOpenDoorServiceGrpc.getCurrentDoorStatusMethod = getCurrentDoorStatusMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailopendoorservice.Payment, generated.grpc.retailopendoorservice.Door>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "RetailOpenDoorService.RetailOpenDoorService", "CurrentDoorStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailopendoorservice.Payment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailopendoorservice.Door.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailOpenDoorServiceMethodDescriptorSupplier("CurrentDoorStatus"))
                  .build();
          }
        }
     }
     return getCurrentDoorStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment,
      generated.grpc.retailopendoorservice.Door> getOpenDoorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenDoor",
      requestType = generated.grpc.retailopendoorservice.Payment.class,
      responseType = generated.grpc.retailopendoorservice.Door.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment,
      generated.grpc.retailopendoorservice.Door> getOpenDoorMethod() {
    io.grpc.MethodDescriptor<generated.grpc.retailopendoorservice.Payment, generated.grpc.retailopendoorservice.Door> getOpenDoorMethod;
    if ((getOpenDoorMethod = RetailOpenDoorServiceGrpc.getOpenDoorMethod) == null) {
      synchronized (RetailOpenDoorServiceGrpc.class) {
        if ((getOpenDoorMethod = RetailOpenDoorServiceGrpc.getOpenDoorMethod) == null) {
          RetailOpenDoorServiceGrpc.getOpenDoorMethod = getOpenDoorMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.retailopendoorservice.Payment, generated.grpc.retailopendoorservice.Door>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RetailOpenDoorService.RetailOpenDoorService", "OpenDoor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailopendoorservice.Payment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.retailopendoorservice.Door.getDefaultInstance()))
                  .setSchemaDescriptor(new RetailOpenDoorServiceMethodDescriptorSupplier("OpenDoor"))
                  .build();
          }
        }
     }
     return getOpenDoorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RetailOpenDoorServiceStub newStub(io.grpc.Channel channel) {
    return new RetailOpenDoorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RetailOpenDoorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RetailOpenDoorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RetailOpenDoorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RetailOpenDoorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RetailOpenDoorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get the doors' status
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Payment> currentDoorStatus(
        io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door> responseObserver) {
      return asyncUnimplementedStreamingCall(getCurrentDoorStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Open the door 
     * </pre>
     */
    public void openDoor(generated.grpc.retailopendoorservice.Payment request,
        io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door> responseObserver) {
      asyncUnimplementedUnaryCall(getOpenDoorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentDoorStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.retailopendoorservice.Payment,
                generated.grpc.retailopendoorservice.Door>(
                  this, METHODID_CURRENT_DOOR_STATUS)))
          .addMethod(
            getOpenDoorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.retailopendoorservice.Payment,
                generated.grpc.retailopendoorservice.Door>(
                  this, METHODID_OPEN_DOOR)))
          .build();
    }
  }

  /**
   */
  public static final class RetailOpenDoorServiceStub extends io.grpc.stub.AbstractStub<RetailOpenDoorServiceStub> {
    private RetailOpenDoorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOpenDoorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOpenDoorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOpenDoorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the doors' status
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Payment> currentDoorStatus(
        io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCurrentDoorStatusMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Open the door 
     * </pre>
     */
    public void openDoor(generated.grpc.retailopendoorservice.Payment request,
        io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RetailOpenDoorServiceBlockingStub extends io.grpc.stub.AbstractStub<RetailOpenDoorServiceBlockingStub> {
    private RetailOpenDoorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOpenDoorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOpenDoorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOpenDoorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Open the door 
     * </pre>
     */
    public generated.grpc.retailopendoorservice.Door openDoor(generated.grpc.retailopendoorservice.Payment request) {
      return blockingUnaryCall(
          getChannel(), getOpenDoorMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RetailOpenDoorServiceFutureStub extends io.grpc.stub.AbstractStub<RetailOpenDoorServiceFutureStub> {
    private RetailOpenDoorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RetailOpenDoorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RetailOpenDoorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RetailOpenDoorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Open the door 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.retailopendoorservice.Door> openDoor(
        generated.grpc.retailopendoorservice.Payment request) {
      return futureUnaryCall(
          getChannel().newCall(getOpenDoorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPEN_DOOR = 0;
  private static final int METHODID_CURRENT_DOOR_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RetailOpenDoorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RetailOpenDoorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPEN_DOOR:
          serviceImpl.openDoor((generated.grpc.retailopendoorservice.Payment) request,
              (io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door>) responseObserver);
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
        case METHODID_CURRENT_DOOR_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.currentDoorStatus(
              (io.grpc.stub.StreamObserver<generated.grpc.retailopendoorservice.Door>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RetailOpenDoorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RetailOpenDoorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.retailopendoorservice.RetailOpenDoorServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RetailOpenDoorService");
    }
  }

  private static final class RetailOpenDoorServiceFileDescriptorSupplier
      extends RetailOpenDoorServiceBaseDescriptorSupplier {
    RetailOpenDoorServiceFileDescriptorSupplier() {}
  }

  private static final class RetailOpenDoorServiceMethodDescriptorSupplier
      extends RetailOpenDoorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RetailOpenDoorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RetailOpenDoorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RetailOpenDoorServiceFileDescriptorSupplier())
              .addMethod(getCurrentDoorStatusMethod())
              .addMethod(getOpenDoorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
