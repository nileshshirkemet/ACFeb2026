using DemoApp.Endpoints;
using DemoApp.Middlewares;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDistributedMemoryCache();
builder.Services.AddSession(); //enable session
var app = builder.Build();
app.UseStaticFiles();
app.UseSession();
app.UseRouting();
app.UseMiddleware<Pausing>();
app.MapGet("/Home", Greeting.Welcome);
app.MapPost("/Login", Greeting.Hello);
app.Run();