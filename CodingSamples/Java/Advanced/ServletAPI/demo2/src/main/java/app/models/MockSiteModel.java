package app.models;

import java.util.ArrayList;
import java.util.List;

import app.tourism.Visitor;

public class MockSiteModel {
    
    private List<Visitor> visitors = new ArrayList<>();

    public MockSiteModel() {
        registerVisit("Jack", 5);
        registerVisit("Jill", 5);
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public boolean registerVisit(String visitorId, int visitorRating) {
        if(visitorId == null || visitorRating < 1 || visitorRating > 5)
            return false;
        var visitor = visitors.stream()
            .filter(e -> e.getId().equals(visitorId))
            .findFirst()
            .orElse(null);
        if(visitor == null){
            visitor = new Visitor(visitorId);
            visitors.add(visitor);
        }
        visitor.visit();
        visitor.setRating(visitorRating);
        return true;
    }
    
}
