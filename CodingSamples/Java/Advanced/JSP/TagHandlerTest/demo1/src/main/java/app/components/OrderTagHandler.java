package app.components;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class OrderTagHandler extends SimpleTagSupport {
    
    public String orderVar;

    public List<CustomerOrder> orderSource;

    public void setOrderVar(String orderVar) {
        this.orderVar = orderVar;
    }

    public void setOrderSource(List<CustomerOrder> orderSource) {
        this.orderSource = orderSource;
    }

    @Override
    public void doTag() throws JspException, IOException {
        var context = super.getJspContext();
        var body = super.getJspBody();
        for(var order : orderSource){
            context.setAttribute(orderVar, order);
            body.invoke(null);
        }
    }

    
}
