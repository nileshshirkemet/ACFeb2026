using Microsoft.EntityFrameworkCore;

namespace DemoApp.Tourism;

public class SiteDbContext : DbContext
{
    public DbSet<Visitor> Visitors { get; set; }

    public SiteDbContext()
    {
        Database.EnsureCreated();
    }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source=data/site.db");
    }
}