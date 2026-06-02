using DemoApp.Shopping;
using Microsoft.EntityFrameworkCore;

var db = new DbContextOptionsBuilder<ShopDbContext>();
db.UseSqlServer("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Encrypt=false");
using var shop = new ShopDbContext(db.Options);
foreach(var product in shop.Products)
{
    Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", product.Id, product.Price, product.Stock);
}