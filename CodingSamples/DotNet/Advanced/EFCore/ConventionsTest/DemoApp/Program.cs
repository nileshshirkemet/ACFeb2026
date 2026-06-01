using DemoApp.Tourism;

using var site = new SiteDbContext();

if(args.Length > 0)
{
    string name = args[0];
    var visitor = site.Visitors.Find(name);
    if(visitor is null)
    {
        visitor = new Visitor { Id = name };
        site.Visitors.Add(visitor);
    }
    visitor.VisitCount += 1;
    visitor.LastVisit = DateTime.Now;
    visitor.Rating = 5;
    site.SaveChanges();
    Console.WriteLine("Welcome {0} to our site!", name);
}
else
{
    var selection = from v in site.Visitors
        where v.Id.Length > 3
        select v;
    foreach(var entry in selection)
    {
        Console.WriteLine("{0, -12}{1, -8}{2, -16}{3, 6}", entry.Id, entry.VisitCount, entry.LastVisit, entry.Stars);
    }
}
