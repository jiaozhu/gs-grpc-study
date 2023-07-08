package com.linux.weijie.grpc.service;

import com.linux.weijie.grpc.lib.HelloReply;
import com.linux.weijie.grpc.lib.HelloRequest;
import com.linux.weijie.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class HelloServiceImpl extends SimpleGrpc.SimpleImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        log.debug("request: {}", request);
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        log.debug("response: {}", reply);
    }
}
