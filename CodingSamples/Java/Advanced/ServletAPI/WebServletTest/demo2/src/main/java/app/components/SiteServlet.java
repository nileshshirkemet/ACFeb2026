package app.components;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.json.JsonMapper;

import app.models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/feedbacks")
public class SiteServlet extends HttpServlet {
    
    //private MockSiteModel model = new MockSiteModel();
    private RealSiteModel model = new RealSiteModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var visitors = model.getVisitors();
        response.setContentType("application/json");
        JsonMapper.builder()
            .defaultDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
            .build()
            .writeValue(response.getWriter(), visitors);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var input = JsonMapper.builder()
            .build()
            .readValue(request.getReader(), Feedback.class);
        if(!model.registerVisit(input.person, input.ranking))
            response.sendError(400);    
    }

    

    
}
