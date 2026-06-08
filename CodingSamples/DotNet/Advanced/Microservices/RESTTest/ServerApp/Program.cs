global using OrderManagerStub = Sales.OrderManager.OrderManagerClient;
using System.IdentityModel.Tokens.Jwt;
using ServerApp.Security;
using ServerApp.Shopping.Endpoints;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddGrpcClient<OrderManagerStub>(
    channel => channel.Address = new Uri("http://localhost:4030")
);
builder.Services.AddAuthentication()
    .AddJwtBearer(options => JwtHelper.ValidateToken(options));
builder.Services.AddAuthorization();
var app = builder.Build();
//mapping minimal-api endpoints
app.MapGet("/api/greet/{id}", async (string id) =>
{
    if(id.Length > 3)
    {
        var resource = new { Message = "Welcome " + id, Ticket = Environment.TickCount % 1000 };
        return Results.Ok(resource);
    }
    return Results.BadRequest();
});
var rest = app.MapGroup("/api/sales");
rest.MapGet("/orders/{customerId}", OrderManagerApi.ReadOrders).RequireAuthorization();
rest.MapPost("/orders", OrderManagerApi.CreateOrder).RequireAuthorization();
app.Run();
