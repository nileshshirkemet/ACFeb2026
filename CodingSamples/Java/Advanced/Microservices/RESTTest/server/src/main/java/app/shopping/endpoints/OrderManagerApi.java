package app.shopping.endpoints;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.shopping.resources.OrderEntry;
import app.shopping.resources.OrderInfo;
import app.shopping.services.OrderManagerClient;
import io.grpc.StatusRuntimeException;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import sales.OrderManagerOuterClass.CustomerInput;
import sales.OrderManagerOuterClass.OrderInput;

@Path("/api/sales/orders")
public class OrderManagerApi {
    
    @Inject
    private OrderManagerClient remote;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readOrders(@PathParam("id") String customerId) {
        var request = CustomerInput.newBuilder()
            .setCustomerCode(customerId)
            .build();
        var reply = remote.stub().fetchOrders(request);
        var resources = new ArrayList<OrderInfo>();
        reply.forEachRemaining(message -> {
            var resource = new OrderInfo();
            resource.productNo = message.getItemCode();
            resource.quantity = message.getItemCount();
            resource.orderDate = message.getConfirmationDate();
            resources.add(resource);
        });
        if(resources.isEmpty())
            return Response.status(404).build();
        return Response.ok(resources).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderEntry resource, @Context SecurityContext securityContext) {
        var request = OrderInput.newBuilder()
            .setCustomerCode(resource.customerId)
            .setItemCode(resource.productNo)
            .setItemCount(resource.quantity)
            .build();
        try{
            var reply = remote.stub().placeOrder(request);
            resource.orderNo = reply.getConfirmationCode();
            var user = securityContext.getUserPrincipal();
            if(user != null)
                Logger.getGlobal().log(Level.INFO, "Order %d placed by agent %s".formatted(resource.orderNo, user.getName()));
            return Response.ok(resource).build();
        }catch(StatusRuntimeException e){
            String fault = e.getStatus().getDescription();
            return Response.status(500, fault).build();
        }
    }
}

