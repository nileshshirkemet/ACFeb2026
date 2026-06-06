using Microsoft.EntityFrameworkCore;
using ServerApp.Shopping.Entities;
using ServerApp.Shopping.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddGrpc(); //enable gRPC
builder.Services.AddDbContext<ShopDbContext>(
    options => options.UseSqlite("Data Source=data/shop.db")
);
var app = builder.Build();
app.MapGrpcService<OrderManagerService>(); //requires HTTP/2 endpoint (see appsettings.json)
app.Run();
