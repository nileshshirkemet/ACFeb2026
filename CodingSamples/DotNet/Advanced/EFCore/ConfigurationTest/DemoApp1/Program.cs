using DemoApp.Shopping;
using Microsoft.EntityFrameworkCore;

using var shop = new ShopDbContext();
if(args.Length == 0)
{
    foreach(var customer in shop.Customers)
        Console.WriteLine("{0, -6}{1, 12:0.00}", customer.Id, customer.Credit);
}
else
{
    string customerId = args[0].ToUpper();
    var customer = shop.Customers
        .Include(c => c.Orders) //eager loading of child entities
        .Where(c => c.Id == customerId)
        .FirstOrDefault();
    if(customer != null)
    {
        foreach(var entry in customer.Orders)
            Console.WriteLine("{0}\t{1}\t{2:yyyy-MM-dd}", entry.ProductId, entry.Quantity, entry.OrderDate);
    }
}