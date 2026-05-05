import java.util.Arrays;

import shopping.Customer;
import shopping.Shop;

class Program {

    public static void main(String[] args) {
        if(args[0].equals("items")){
            var items = Shop.getItems();
            Arrays.stream(items)
                .filter(i -> i.brand().equals(args[1]))
                .map(i -> i.name())
                .forEach(System.out::println);
        }else if(args[0].equals("customers")) {
            double min = Double.parseDouble(args[1]);
            var customers = Shop.getCustomers();
            customers.add(new Customer("Xavier", 88000, 3));
            customers.stream()
                .filter(c -> c.purchase() >= min)
                .sorted()
                .forEach(c -> System.out.printf("%s\t%s%n", c.id(), c.stars()));
        }

    }
}
