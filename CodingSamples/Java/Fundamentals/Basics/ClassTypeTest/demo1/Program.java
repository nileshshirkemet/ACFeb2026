class Program {

    private static void advise(Investment inv) {
        double amount = inv.totalPayment();
        inv.allowRisk(amount < 500000);
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome Investor!");
        double p = Double.parseDouble(args[0]);
        int n = Integer.parseInt(args[1]);
        Investment myinv = new Investment(p, n);
        System.out.printf("Future value in riskless investment: %.2f%n", myinv.futureValue());
        myinv.allowRisk(true);
        System.out.printf("Future value in low-risk investment: %.2f%n", myinv.futureValue());
        advise(myinv);
        System.out.printf("Future value in smart investment   : %.2f%n", myinv.futureValue());

    }
}
