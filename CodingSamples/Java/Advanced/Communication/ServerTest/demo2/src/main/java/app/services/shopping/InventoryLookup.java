package app.services.shopping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import app.services.common.CommunicationLayer;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class InventoryLookup implements CommunicationLayer {

    @Inject
    private DataAccessLayer storeroom;

    @Inject
    @Named("wholesale")
    private DataAccessLayer warehouse;

    @Override
    public void communicate(BufferedReader input, PrintWriter output) throws IOException {
        output.println("Welcome to MET-DIGITAL supply.");
        String name = input.readLine();
        var info = storeroom.readItemInfo(name);
        if(info == null)
            info = warehouse.readItemInfo(name);
        if(info != null){
            output.printf("COST is %s and STOCK is %s%n", info.cost(), info.stock());
        }
    }
    
    
}
