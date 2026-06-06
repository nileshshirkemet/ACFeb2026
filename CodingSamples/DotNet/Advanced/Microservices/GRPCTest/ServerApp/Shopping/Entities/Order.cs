namespace ServerApp.Shopping.Entities;

public class Order
{
    public int Id { get; set; }

    public DateOnly OrderDate { get; set; }

    public string CustomerId { get; set; }

    public int ProductId { get; set; }

    public int Quantity { get; set; }
}