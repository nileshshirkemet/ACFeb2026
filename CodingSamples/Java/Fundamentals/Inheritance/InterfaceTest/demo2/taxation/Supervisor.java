package taxation;

public class Supervisor implements TaxPayer {
    
    private int subordinates;

    public Supervisor(int subordinates) {
        this.subordinates = subordinates;
    }

    public double annualIncome() {
        return 480000 + 3000 * subordinates;
    }
    
}
