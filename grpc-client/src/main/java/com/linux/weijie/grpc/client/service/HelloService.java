package com.linux.weijie.grpc.client.service;

import com.linux.weijie.grpc.lib.HelloRequest;
import com.linux.weijie.grpc.lib.SimpleGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    @GrpcClient("simple-service")
    private SimpleGrpc.SimpleBlockingStub simpleBlockingStub;

    public String receiveGreeting(String name) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        return simpleBlockingStub.sayHello(request).getMessage();
    }
}
