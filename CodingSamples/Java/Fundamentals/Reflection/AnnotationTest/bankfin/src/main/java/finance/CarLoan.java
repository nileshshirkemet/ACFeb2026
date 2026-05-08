package finance;

public class CarLoan extends PersonalLoan{
    
    @Override
    public float common(double amount, int period) {
        return (amount < 1000000 ? 11 : 12) + (period > 3 ? 1 : 0);
    }
}
