using DemoApp.Models;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllers(); //enable Web API
builder.Services.AddTransient<SiteModel>();
var app = builder.Build();
app.UseStaticFiles();
app.UseRouting();
//map endpoints using [Route] attribute applied to controllers
app.MapControllers();
app.MapFallbackToFile("index.html"); 
app.Run();
