package app.models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class WebItemStore implements DataAccessLayer {

    @Override
    public ItemInfo fetchItemInfo(String name) {
        try(var client = HttpClient.newHttpClient()){
            var url = URI.create("http://iitdac.met.edu/shop/" + name);
            var request = HttpRequest.newBuilder(url)
                .GET()
                .header("Accept", "text/plain")
                .build();
            var response = client.send(request, BodyHandlers.ofString());
            if(response.statusCode() == 200){
                String reply = response.body();
                String[] segs = reply.split("[=;]");
                return new ItemInfo(
                    Double.parseDouble(segs[1]),
                    Integer.parseInt(segs[3])
                );
            }
            return new ItemInfo(0, 0);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
}
