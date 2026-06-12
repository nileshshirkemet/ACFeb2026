package app.components;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GamblingServlet extends HttpServlet {
    
    private static Random lotto = new Random();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int winner = lotto.nextInt(10000000, 100000000);
        response.setContentType("text/html");
        response.getWriter().printf("""
            <html>
                <head>
                    <title>DemoApp</title>
                </head>
                <body>
                    <h1>Welcome Player</h1>
                    <b>Jackpot Number: </b>%d
                </body>
            </html>              
            """, winner);
    }

    
}
