class Investment {
    
    //instance fields
    private double installment;
    private int years;
    private boolean risk;

    //constructor - initializes new instance of the class,
    //a class implicitly supports a parameterless constructor
    //if it does not explicitly define a constructor
    public Investment(double amount, int period) {
        installment = amount;
        years = period;
        risk = false;
    }

    //instance method - must be called on an object
    //which is available in the body of the method
    //through 'this' keyword and as such it can
    //reference any other member of the class
    public void allowRisk(boolean yes) {
        risk = yes;
    }

    public double totalPayment() {
        return years * installment;
    }

    public double futureValue() {
        float i = risk ? 0.08f : 0.06f;
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }
}
