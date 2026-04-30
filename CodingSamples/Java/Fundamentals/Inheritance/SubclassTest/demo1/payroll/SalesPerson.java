package payroll;

//defining SalesPerson as a subclass of Employee(super-class)
public class SalesPerson extends Employee {
    
    private double sales;

    public SalesPerson(int h, float r, double s) {
        super(h, r); //subclass constructor must call super-class constructor
        sales = s;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double value) {
        sales = value;
    }

    //method overriding - defining a method in the sub-class
    //whose declaration matches with the declaration of a method
    //in super-class
    public double income() {
        double amount = super.income();
        if(sales >= 20000)
            amount += 0.05 * sales;
        return amount;
    }
}
