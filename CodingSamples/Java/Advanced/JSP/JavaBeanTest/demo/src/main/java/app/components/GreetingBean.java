package app.components;

public class GreetingBean {

    private String person;

    private String period;

    private int count;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getGreetCount() {
        return count;
    }

    public synchronized String getMessage() {
        if(person == null)
            return "Hello Visitor";
        count += 1;
        return "Good %s %s".formatted(period, person);
    }
    
}
