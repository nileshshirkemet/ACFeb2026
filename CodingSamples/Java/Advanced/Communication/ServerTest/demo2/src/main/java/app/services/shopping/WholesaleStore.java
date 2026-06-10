package app.services.shopping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WholesaleStore implements DataAccessLayer {

    @Override
    public ItemInfo readItemInfo(String name) {
        try(var document = Files.newBufferedReader(Path.of("data/wholesale.csv"))){
            return document.lines()
                .skip(1)
                .filter(line -> line.startsWith(name))
                .map(line -> line.split(","))
                .map(segs -> new ItemInfo(
                    name, 
                    Double.parseDouble(segs[1]), 
                    Integer.parseInt(segs[2])
                ))
                .findFirst()
                .orElse(null);


        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    
    
}
