package app.services.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.helpers.AppConfig;
import jakarta.inject.Inject;

public class TransportLayer {

    private final Logger logging = Logger.getLogger("TransportLayer");

    private CommunicationLayer protocol;

    @Inject
    public TransportLayer(CommunicationLayer protocol) {
        this.protocol = protocol;    
    }
    
    public void run() throws IOException {
        Integer port = AppConfig.getSetting("server.port", 4010);
        logging.log(Level.INFO, "Starting server on TCP port {0}...", port.toString());
        //Step 1
        var listener = ServerSocketChannel.open();
        listener.bind(new InetSocketAddress(port));
        while(true){
            //Step 2
            var connection = listener.accept();
            //Step 3
            Thread.ofVirtual().start(() -> onConnect(connection));
        }
    }

   private void onConnect(SocketChannel client) {
        try(client){
            //Step 3a
            var reader = new BufferedReader(Channels.newReader(client, StandardCharsets.UTF_8));
            var writer = new PrintWriter(Channels.newWriter(client, StandardCharsets.UTF_8), true);
            //Step 3b
            protocol.communicate(reader, writer);
            writer.close();
            reader.close();
        }catch(Exception e){
            logging.log(Level.SEVERE, "Communication failure", e);
        }
        //Step 3c - client is AutoCloseable
    }
}
