package app.shopping.services;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import sales.OrderManagerGrpc;
import sales.OrderManagerGrpc.OrderManagerBlockingStub;

public class OrderManagerClient {
    
    private ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 4030)
        .usePlaintext()
        .build();

    public OrderManagerBlockingStub stub() {
        return OrderManagerGrpc.newBlockingStub(channel);
    }

    @PreDestroy
    public void stop() {
        channel.shutdown();
    }
}
