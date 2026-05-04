class Investment {

    //final instance field can only be initialized in a constructor
    //and it must be initialized in every constructor, a class with
    //all final instance fields produces immutable objects 
    private final double installment;
    private final int years;

    public Investment(double installment, int years) {
        this.installment = installment;
        this.years = years;
    }

    public double futureValue(Interest rate) {
        float i = rate.forPeriod(years) / 100;
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }

}
