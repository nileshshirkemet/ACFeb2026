using DemoApp.Models;
using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews(); //enable full MVC
builder.Services.AddSingleton<IHitCounter, PersonalCounter>();
builder.Services.AddTransient<SiteModel>();
var app = builder.Build();
app.MapGet("/Ping", () => DateTime.Now.Ticks);
//map path /X/Y to each action method Y defined by a Controller 
//derived class XController with X=Home and Y=Index as default 
app.MapDefaultControllerRoute();
app.Run();
