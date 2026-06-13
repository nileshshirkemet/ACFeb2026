package app.tourism;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Visitor {
    
    String id;

    int visitCount;

    Timestamp lastVisit;

    int rating;

    public Visitor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public Timestamp getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Timestamp lastVisit) {
        this.lastVisit = lastVisit;
    }

    @JsonIgnore
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStars() {
        return "*".repeat(rating);
    }

    public void visit() {
        visitCount += 1;
        lastVisit = new Timestamp(System.currentTimeMillis());
    }

}
