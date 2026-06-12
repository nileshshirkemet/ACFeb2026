package app.components;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class CountingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String person = request.getParameter("visitor");
        if(person.length() == 0)
            person = "Friend";
        var session = request.getSession(true);
        Integer count = (Integer) session.getAttribute(person);
        if(count == null)
            count = 0;
        session.setAttribute(person, ++count);
        response.setContentType("text/html");
        response.getWriter().printf("""
            <html>
                <head>
                    <title>DemoApp</title>
                </head>
                <body>
                    <h1>Hello %s</h1>
                    <b>Number of Greetings: </b>%d
                </body>
            </html>
            """, person, count);
    }
    
}
