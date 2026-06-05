using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages(); //enable razor-pages
builder.Services.AddScoped<IHitCounter, UniversalCounter>();
var app = builder.Build();
//map razor-syntax handler to path /X for each ~/Pages/X.cshtml
//which begins with @page directive, unless this directive 
//specifies an alternate path and use Index for default path
app.MapRazorPages();
app.Run();
