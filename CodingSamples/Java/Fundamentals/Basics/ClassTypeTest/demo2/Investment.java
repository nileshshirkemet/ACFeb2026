class Investment {
    
    private double installment;
    private int years;
    private RiskLevel risk;

    public Investment(double amount, int period) {
        installment = amount;
        years = period;
        risk = RiskLevel.NONE;
    }

    public void allowRisk(boolean yes) {
        risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
    }

    //method oveloading - defining a method whose name
    //matches with the name of another method in its
    //class but has differnt list of parameter types
    public void allowRisk(RiskLevel level) {
        risk = level;
    }

    public double totalPayment() {
        return years * installment;
    }

    public double futureValue() {
        float i;
        switch(risk){
            case LOW:
                i = 0.08f;
                break;
            case HIGH:
                i = 0.11f;
                break;
            default:
                i = 0.06f;
        }
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }
}
