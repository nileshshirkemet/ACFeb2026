package app.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Greet/*")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var application = super.getServletContext();
        String pi = request.getPathInfo();
        String name = pi != null ? pi.substring(1) : "Friend";
        Integer count;
        synchronized(application){
            count = (Integer) application.getAttribute(name);
            if(count == null)
                count = 0;
            application.setAttribute(name, ++count);
        }
        String page = request.getHeader("User-Agent").contains("Mobile")
            ? application.getRealPath("/WEB-INF/templates/hello.html")
            : application.getRealPath("/WEB-INF/templates/welcome.html");
        String content = Files.readString(Path.of(page))
            .replace("|guest.name|", name)
            .replace("|greet.count|", count.toString());
        response.setContentType("text/html");
        response.getWriter().write(content);
    }
    
    
}
