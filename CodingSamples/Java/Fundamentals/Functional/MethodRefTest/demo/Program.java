import java.util.Scanner;

class Program {
    
    static float safeScheme(int count) {
        return count < 3 ? 6 : 7;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Installment    : ");
        double p = input.nextDouble();
        System.out.print("Number of Years: ");
        int n = input.nextInt();
        var myinv = new Investment(p, n);
        System.out.printf("Future value in riskless investment: %.2f%n", myinv.futureValue(Program::safeScheme));
        int m = 8;
        //passing lamda-expression which captures local variable(m) by copy
        //makes that local variable effectively final
        System.out.printf("Future value in riskful investment : %.2f%n", myinv.futureValue(y -> m + 0.25f * y));
        input.close();
    }
}
