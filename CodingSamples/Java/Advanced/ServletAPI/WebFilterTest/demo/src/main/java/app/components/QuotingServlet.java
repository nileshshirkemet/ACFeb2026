package app.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.qtn")
public class QuotingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sp = request.getServletPath();
        String rp = super.getServletContext().getRealPath(sp);
        if(rp != null){
            String quote = Files.readString(Path.of(rp));
            response.setContentType("text/html");
            response.getWriter().printf("""
                    <html>
                        <head>
                            <title>DemoApp</title>
                        </head>
                        <body>
                            <h1>Quotation</h1>
                            <i>%s</i>
                            <hr/>
                            %s
                        </body>
                    </html>
                """, quote, new Date());
        }else{
            response.sendError(404, "File Not Found");
        }
    }
    
    
}
