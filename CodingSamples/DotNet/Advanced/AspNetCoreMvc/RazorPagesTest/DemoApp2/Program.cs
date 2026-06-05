using DemoApp.Shopping;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages();
builder.Services.AddDbContext<ShopDbContext>(
    options => options.UseSqlServer("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Encrypt=false")
);
//enable (cookies) authentication which also adds authentication 
//and authorization middlewares to the request pipeline
builder.Services.AddAuthentication()
    .AddCookie(options => options.LoginPath = "/Index");
var app = builder.Build();
app.MapRazorPages();
app.Run();
