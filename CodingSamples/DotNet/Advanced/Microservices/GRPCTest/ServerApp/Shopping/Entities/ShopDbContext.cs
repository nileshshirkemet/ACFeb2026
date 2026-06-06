using Microsoft.EntityFrameworkCore;

namespace ServerApp.Shopping.Entities;

public class ShopDbContext(DbContextOptions options) : DbContext(options)
{
    public DbSet<Order> Orders { get; set; }

    public DbSet<Counter> Counters { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Order>()
            .ToTable("OrderDetail")
            .Property(p => p.Id)
            .HasColumnName("OrderNo");
        modelBuilder.Entity<Order>()
            .Property(p => p.ProductId)
            .HasColumnName("ProductNo");
    }
}