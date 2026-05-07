package finance;

public class HomeLoan {

    public float common(double amount, int period) {
        return amount < 5000000 ? 8.5f : 8.0f;
    }
}
