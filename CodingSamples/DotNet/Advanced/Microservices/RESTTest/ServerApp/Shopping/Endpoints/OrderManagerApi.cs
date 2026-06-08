using System.Security.Claims;
using Grpc.Core;
using Grpc.Core.Utils;
using Sales;
using ServerApp.Shopping.Resources;

namespace ServerApp.Shopping.Endpoints;

public class OrderManagerApi
{
    public static async Task<IResult> ReadOrders(string customerId, OrderManagerStub remote)
    {
        var request = new CustomerInput { CustomerCode = customerId };
        using var reply = remote.FetchOrders(request);
        var resources = from message in await reply.ResponseStream.ToListAsync()
            select new OrderInfo
            {
                ProductNo = message.ItemCode,
                Quantity = message.ItemCount,
                OrderDate = message.ConfirmationDate
            };
        if(resources.Any())
            return Results.Ok(resources);
        return Results.NotFound();
    }

    public static async Task<IResult> CreateOrder(OrderEntry resource, OrderManagerStub remote, ILogger<OrderManagerApi> logging, ClaimsPrincipal user)
    {
        var request = new OrderInput
        {
            CustomerCode = resource.CustomerId,
            ItemCode = resource.ProductNo,
            ItemCount = resource.Quantity
        };
        try
        {
            var reply = await remote.PlaceOrderAsync(request);
            if(user.Identity.IsAuthenticated)
                logging.LogInformation("Order {a} placed by {b}", reply.ConfirmationCode, user.Identity.Name);
            var output = resource with { OrderNo = reply.ConfirmationCode }; //initializing copy with additional properties
            return Results.Ok(output);
        }
        catch(RpcException ex)
        {
            return Results.Problem(ex.Status.Detail, "CreateOrder", 500);
        }
    }
}