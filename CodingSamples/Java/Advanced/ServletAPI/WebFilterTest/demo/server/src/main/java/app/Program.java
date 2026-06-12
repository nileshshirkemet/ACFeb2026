package app;

import java.io.File;

import org.eclipse.jetty.ee10.webapp.WebAppContext;
import org.eclipse.jetty.server.Server;

public class Program {
    
    public static void main(String[] args) throws Exception {
        var jetty = new Server(Integer.parseInt(System.getProperty("server.http.port", "5000")));
        jetty.setHandler(new WebAppContext(new File(args[0]).getAbsolutePath(), "/")); 
        jetty.start();
        jetty.join();
    }
}

