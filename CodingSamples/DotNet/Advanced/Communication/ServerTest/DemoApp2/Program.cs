using DemoApp.Services.Common;
using DemoApp.Services.Shopping;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

var builder = Host.CreateApplicationBuilder(args);
builder.Services.AddHostedService<TransportLayer>();
builder.Services.AddTransient<ICommunicationLayer, InventoryLookup>();
builder.Services.AddSingleton<IDataAccessLayer, RetailStore>();
builder.Services.AddKeyedTransient<IDataAccessLayer, WholesaleStore>("wholesale");
var app = builder.Build();
app.Run();

