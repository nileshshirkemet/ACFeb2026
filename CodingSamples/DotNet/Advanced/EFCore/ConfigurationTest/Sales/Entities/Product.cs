namespace Sales.Entities;

public class Product
{
    public int Id { get; set; }

    public decimal Price { get; set; }

    public int Stock { get; set; }

    public ICollection<Order> Orders { get; set; } = [];
}