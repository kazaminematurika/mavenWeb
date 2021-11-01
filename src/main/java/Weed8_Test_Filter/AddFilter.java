package Weed8_Test_Filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
public class AddFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (request.getParameter("param") == null || (request.getParameter("param")).length() == 0) {
            Vector vector = new Vector();
            filterConfig.getServletContext().setAttribute("result", vector);
        } else {
            Vector vector = (Vector) filterConfig.getServletContext().getAttribute("result");
            if (vector.size() == 0){
                vector.add(request.getParameter("param"));
            }
            vector.add("+");
            vector.add(filterConfig.getInitParameter("add"));
            filterConfig.getServletContext().setAttribute("result", vector);
        }try {
            filterChain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            filterConfig.getServletContext().log(e.getMessage());
        }
    }
    @Override
    public void destroy() {
    }
}
