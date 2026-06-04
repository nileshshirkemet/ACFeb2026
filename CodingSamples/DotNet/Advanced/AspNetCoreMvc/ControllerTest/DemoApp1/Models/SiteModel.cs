using DemoApp.Tourism;

namespace DemoApp.Models;

public class SiteModel
{
    public List<Visitor> FetchVisitors()
    {
        using var site = new SiteDbContext();
        return site.Visitors.ToList();
    }

    public void AcceptVisit(string visitorId, int visitorRating)
    {
        using var site = new SiteDbContext();
        var visitor = site.Visitors.Find(visitorId);
        if(visitor is null)
        {
            visitor = new Visitor { Id = visitorId };
            site.Visitors.Add(visitor);
        }
        visitor.VisitCount += 1;
        visitor.LastVisit = DateTime.Now;
        visitor.Rating = visitorRating;
        site.SaveChanges();
    }
}