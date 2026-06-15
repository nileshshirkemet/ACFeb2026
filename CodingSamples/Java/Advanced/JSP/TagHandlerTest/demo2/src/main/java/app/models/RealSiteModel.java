package app.models;

import java.util.List;

import app.tourism.SiteRepository;
import app.tourism.Visitor;

public class RealSiteModel {
    
    private SiteRepository repository = new SiteRepository();

    public List<Visitor> getVisitors() {
        return repository.findAllVisitors();
    }

    public boolean registerVisit(String visitorId, int visitorRating) {
        if(visitorId == null || visitorRating < 1 || visitorRating > 5)
            return false;
        var visitor = repository.findVisitorById(visitorId);
        if(visitor == null){
            visitor = new Visitor(visitorId);
        }
        visitor.visit();
        visitor.setRating(visitorRating);
        repository.save(visitor);
        return true;
    }
}
