package finance;

@Flexible
public class PersonalLoan {

    @MaxDuration(value = 6)
    public float common(double amount, int period) {
        return 10 + 0.5f * (period / 3);
    }

    public float employee(double amount, int period) {
        return 0.5f * common(amount, period);
    }
}
