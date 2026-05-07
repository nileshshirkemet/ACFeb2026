package finance;

public class LoanHelper {
    
    public static double monthlyInstallment(double loan, int years, float rate) {
        int m = 12 * years;
        float i = rate / 1200;
        return loan * i / (1 - Math.pow(1 + i, -m));
    }
}
