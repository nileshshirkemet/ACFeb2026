package app.views;

import app.models.DataAccessLayer;

public class PresentationLayer {
    
    private DataAccessLayer model;

    public PresentationLayer(DataAccessLayer store) {
        this.model = store;
    }

    public void render() {
        IO.println("Welcome Customer.");
        IO.print("Item    : ");
        String name = IO.readln().toLowerCase();
        IO.print("Quantity: ");
        int quantity = Integer.parseInt(IO.readln());
        var info = model.fetchItemInfo(name);
        if(quantity <= info.stockLevel())
            System.out.printf("Total Payment: %.2f%n", 1.05 * quantity * info.unitCost());
        else
            IO.println("Not available!");

    }
}
