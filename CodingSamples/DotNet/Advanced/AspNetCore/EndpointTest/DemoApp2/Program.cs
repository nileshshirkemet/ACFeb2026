using DemoApp.Endpoints;
using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
//builder.Services.AddSingleton<IHitCounter>(sp => new PersonalCounter(1, 1));
builder.Services.AddScoped<IHitCounter, UniversalCounter>();
var app = builder.Build();
app.MapGet("/Home", Greeting.Welcome);
app.MapPost("/Login", Greeting.Hello);
app.Run();