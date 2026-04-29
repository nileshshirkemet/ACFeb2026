class Investment {
    
    //a method declared with 'static' keyword can be called on the class
    //and as such it can only reference other static members
    public static double futureValue(double installment, int years) {
        float i = 0.06f;
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }
}
