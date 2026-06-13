package app.components;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class ClockTagHandler extends SimpleTagSupport {
    
    private String timeFormat = "yyyy-MM-dd HH:mm:ss";

    //used for setting corresponding attribute
    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    @Override
    public void doTag() throws JspException, IOException {
        var context = super.getJspContext();
        String time = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern(timeFormat));
        context.getOut().write(time);
    }

    

    
}
