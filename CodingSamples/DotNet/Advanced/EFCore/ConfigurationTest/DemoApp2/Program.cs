using DemoApp.Shopping;
using Microsoft.EntityFrameworkCore;

var db = new DbContextOptionsBuilder<ShopDbContext>();
if(args.Length > 1 && args[1] == "server")
    db.UseSqlServer("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Encrypt=false");
else
    db.UseSqlite("Data Source=data/shop.db");
using var shop = new ShopDbContext(db.Options);
int pno = int.Parse(args[0]);
var product = shop.Products.Find(pno);
if(product == null)
{
    foreach(var item in shop.Products)
    {
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", item.Id, item.Price, item.Stock);
    }
}
else
{
    shop.Entry(product).Collection(p => p.Orders).Load(); //explicit loading of child entities
    foreach(var entry in product.Orders)
    {
        Console.WriteLine("{0}\t{1}\t{2:dd-MMM-yyyy}", entry.CustomerId, entry.Quantity, entry.OrderDate);
    }
}