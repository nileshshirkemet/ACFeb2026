import models.SupplierModel;

class Program {

    public static void main(String[] args) {
        var model = new SupplierModel();
        var suppliers = model.readSuppliers();
        suppliers.stream()
            .sorted((s, t) -> t.quantity() - s.quantity())
            .forEach(s -> System.out.printf("%-12s%-12s%8d%n", s.name(), s.item(), s.quantity()));
        if(args.length > 0){
            int total = suppliers.stream()
                .filter(s -> s.item().equals(args[0]))
                .mapToInt(s -> s.quantity())
                .sum();
            System.out.println();
            System.out.printf("Total supply for %s is %d%n", args[0], total);
        }
    }
}
