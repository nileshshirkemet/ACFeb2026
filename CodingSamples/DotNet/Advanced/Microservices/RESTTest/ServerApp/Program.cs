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
//web-browser only allows client side code downloaded from a particular endpoint
//to consume resources exchanged by that same endpoint (same origin policy) or 
//from another endpoint which supports cross-origin resource sharing(CORS) by
//sending relevant headers(Access-Control-Allow-*)
builder.Services.AddCors(); //enable CORS
var app = builder.Build();
app.UseCors(); //pass CORS header
app.UseAuthentication();
app.UseAuthorization();
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
rest.MapGet("/agents/{id}/{passcode}", SalesAgentApi.SignIn);
rest.RequireCors(policy => policy
    .WithOrigins("http://localhost:5001")
    .AllowAnyMethod()
    .AllowAnyHeader()    
);
app.Run();
