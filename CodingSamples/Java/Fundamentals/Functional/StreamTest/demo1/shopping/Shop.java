package shopping;

import java.util.ArrayList;
import java.util.Collection;

public class Shop {

    private Shop() {}
    
    public static Item[] getItems() {
        return new Item[]{
            new Item("cpu", "intel"),
            new Item("ddr", "samsung"),
            new Item("motherboard", "intel"),
            new Item("cpu", "amd"),
            new Item("mouse", "logitech"),
            new Item("ssd", "sandisk"),
            new Item("keyboard", "logitech"),
            new Item("ssd", "samsung"),
            new Item("mouse", "microsoft"),
            new Item("monitor", "samsung")
        };
    }

    public static Collection<Customer> getCustomers() {
        var customers = new ArrayList<Customer>();
        customers.add(new Customer("Sandeep", 45000, 3));
        customers.add(new Customer("Pratha", 60000, 4));
        customers.add(new Customer("Ketan", 85000, 5));
        customers.add(new Customer("Akash", 30000, 1));
        customers.add(new Customer("Roshani", 55000, 2));
        customers.add(new Customer("Gauri", 120000, 5));
        customers.add(new Customer("Yash", 90000, 4));
        customers.add(new Customer("Manoj", 40000, 3));
        customers.add(new Customer("Nishant", 75000, 4));
        customers.add(new Customer("Vivek", 25000, 2));
        return customers;
    }
}
