package app.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetItemStore implements DataAccessLayer {

    private String host;
    
    public NetItemStore(String host) {
        this.host = host;
    }

    @Override
    public ItemInfo fetchItemInfo(String name) {
        //Step 1
        try(var connection = new Socket(host, 4020)){
            //Step 2a
            var remoteIn = connection.getInputStream();
            var reader = new BufferedReader(new InputStreamReader(remoteIn));
            var remoteOut = connection.getOutputStream();
            var writer = new PrintWriter(remoteOut, true);
            //Step 2b
            reader.readLine(); //read and ignore greeting message
            writer.println(name);
            String reply = reader.readLine();
            writer.close();
            reader.close();
            if(reply != null){
                String[] segs = reply.split(" ");
                return new ItemInfo(
                    Double.parseDouble(segs[2]),
                    Integer.parseInt(segs[6])
                );
            }
            return new ItemInfo(0, 0);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        //Step 2c - client is AutoCloseable
    }
    
}
