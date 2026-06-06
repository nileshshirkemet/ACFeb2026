using Grpc.Core;
using Grpc.Core.Utils;
using Sales;
using ServerApp.Shopping.Entities;

namespace ServerApp.Shopping.Services;

public class OrderManagerService(ShopDbContext shop) : OrderManager.OrderManagerBase
{
    public override async Task<OrderStatus> PlaceOrder(OrderInput request, ServerCallContext context)
    {
        var counter = await shop.Counters.FindAsync("order");
        var order = new Order
        {
            Id = ++counter.CurrentValue + counter.SeedValue,
            OrderDate = DateOnly.FromDateTime(DateTime.Now),
            CustomerId = request.CustomerCode,
            ProductId = request.ItemCode,
            Quantity = request.ItemCount
        };
        shop.Orders.Add(order);
        try
        {
            await shop.SaveChangesAsync();
            return new OrderStatus { ConfirmationCode = order.Id };
        }
        catch(Exception)
        {
            context.Status = new Status(StatusCode.Internal, "Order Failed");
            return new OrderStatus { ConfirmationCode = -1 };
        }
    }

    public override async Task FetchOrders(CustomerInput request, IServerStreamWriter<CustomerOrder> responseStream, ServerCallContext context)
    {
        var messages = from entity in shop.Orders
            where entity.CustomerId == request.CustomerCode
            select new CustomerOrder
            {
                ItemCode = entity.ProductId,
                ItemCount = entity.Quantity,
                ConfirmationDate = entity.OrderDate.ToString("yyyy-MM-dd")
            };
            await responseStream.WriteAllAsync(messages);
    }
}