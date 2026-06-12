package app.components;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PausingFilter implements Filter{

    private long last = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long current = System.currentTimeMillis();
        if(current - last > 3000){
            chain.doFilter(request, response);
            last = current;
        }else{
            var resp = (HttpServletResponse) response;
            resp.sendError(503, "Server busy");
        }
    }
    
    
}
