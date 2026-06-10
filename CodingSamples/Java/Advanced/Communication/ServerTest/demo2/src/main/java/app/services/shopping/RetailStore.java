package app.services.shopping;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class RetailStore implements DataAccessLayer {

    private final ItemInfo[] items;

    public RetailStore() throws IOException {
        try(var document = new FileInputStream("data/retail.json")){
            items = JsonMapper.builder()
                .build()
                .readValue(document, ItemInfo[].class);
        }
    }

    @Override
    public ItemInfo readItemInfo(String name) {
        return Arrays.stream(items)
            .filter(i -> i.id().equals(name))
            .findFirst()
            .orElse(null);
    }
    
    
}
