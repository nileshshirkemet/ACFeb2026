package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class SupplierModel {
    
    public Collection<Supplier> readSuppliers() {
        try(var reader = new BufferedReader(new FileReader("suppliers.csv"))){
            return reader.lines()
                .skip(1)
                .map(Supplier::new) //method-reference for constructor
                .collect(Collectors.toList());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
