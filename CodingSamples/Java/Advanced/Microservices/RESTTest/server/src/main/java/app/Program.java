package app;

import java.net.URI;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ResourceConfig;

import app.shopping.services.OrderManagerClient;

public class Program extends AbstractBinder {

    public void configure() {
        bindAsContract(OrderManagerClient.class).in(RequestScoped.class);
	}
   
    public static void main(String[] args) throws Exception {
        var server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create(System.getProperty("server.url", "http://0.0.0.0:5000/")),
            new ResourceConfig().register(Program.class).packages("app")            
        );
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
    }

}

