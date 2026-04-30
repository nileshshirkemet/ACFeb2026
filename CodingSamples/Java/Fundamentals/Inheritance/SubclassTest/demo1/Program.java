import payroll.Employee; //compiler will qualify Employee to payroll.Employee
import payroll.SalesPerson;

class Program {

    private static double tax(Employee emp) {
        //every instance contains a reference to the class
        //from which it was instantiated (by new operator)
        //and invocation of instance method is dispatched
        //at runtime to this class by default (dynamic-binding)
        double i = emp.income();
        return i < 10000 ? 0 : 0.15 * (i - 10000);
    }

    private static double bonus(Employee emp) {
        double i = emp.income();
        if(emp instanceof SalesPerson)
            return 0.06 * i;
        return 0.09 * i;
    }

    public static void main(String[] args) {
        Employee jack = new Employee();
        jack.setHours(186);
        jack.setRate(52);
        System.out.printf("Jack's Income is %.2f, Tax is %.2f and Bonus is %.2f%n", jack.income(), tax(jack), bonus(jack));
        SalesPerson jill = new SalesPerson(186, 52, 64000);
        System.out.printf("Jill's Income is %.2f, Tax is %.2f and Bonus is %.2f%n", jill.income(), tax(jill), bonus(jill));
    }
}
