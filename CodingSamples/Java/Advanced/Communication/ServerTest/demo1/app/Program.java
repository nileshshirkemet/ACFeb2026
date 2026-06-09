package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Program {
    
    private static Map<String, String> store = Map.ofEntries(
        Map.entry("chair", "COST is 4500 with STOCK of 50"),
        Map.entry("desk", "COST is 3000 with STOCK of 40"),
        Map.entry("cabinet", "COST is 2500 with STOCK of 30")
    );

    public static void main(String[] args) throws Exception {
        System.out.println("Starting server on TCP port 4010...");
        //step 1
        var listener = new ServerSocket(4010);
        while(listener.isBound()){
            //step 2
            var connection = listener.accept();
            //step 3
            //onConnect(connection);
            Thread.ofPlatform().start(() -> onConnect(connection));
        }
        listener.close();
    }

    private static void onConnect(Socket client) {
        try(client){
            //Step 3a
            var remoteIn = client.getInputStream();
            var reader = new BufferedReader(new InputStreamReader(remoteIn));
            var remoteOut = client.getOutputStream();
            var writer = new PrintWriter(remoteOut);
            //Step 3b
            writer.println("Welcome to MET-OFFICE supply.");
            writer.flush();
            String name = reader.readLine();
            String info = store.get(name);
            if(info != null){
                writer.println(info);
                writer.flush();
            }
            writer.close();
            reader.close();
        }catch(IOException e){
            System.out.printf("Communication failure: %s%n", e.getMessage());
        }
        //Step 3c: client is auto-closeable
    }
}
