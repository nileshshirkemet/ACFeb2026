package app.components;

import java.time.LocalDateTime;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebAppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String pattern = LocalDateTime.now()
            .getDayOfWeek()
            .name();
        sce.getServletContext()
            .addServlet("gambler", new GamblingServlet())
            .addMapping("/" + pattern);
            
    }
    

}
