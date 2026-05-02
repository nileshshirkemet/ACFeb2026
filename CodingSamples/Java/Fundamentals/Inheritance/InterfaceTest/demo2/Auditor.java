import java.util.Date;

import taxation.TaxPayer;

class Auditor implements AutoCloseable {

    public Auditor() {
        System.out.printf("Auditor Log[%s]: opening audit session...%n", new Date());
    }

    public void audit(String id, TaxPayer info) {
        if(id.length() < 4)
            throw new IllegalArgumentException("Invalid ID");
        double payment = info.incomeTax() + 500;
        System.out.printf("Total Tax Payment: %.2f%n", payment);
    }

    public void close() {
        System.out.printf("Auditor Log[%s]: closing audit session...%n", new Date());
    }
}
