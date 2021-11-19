package Weed12_Test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


/**
 * @author Kazamine_Setueka
 */
public class filter extends HttpServlet implements Filter {

    private FilterConfig filterConfig;


    @Override
    public void init(FilterConfig FilterConfig) throws ServletException {
        this.filterConfig = FilterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain FilterChain) throws IOException, ServletException {
        String paramVaule = filterConfig.getInitParameter("");
        try{
            String string = request.getParameter("");
            if (string == null){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("" + paramVaule);
                requestDispatcher.forward(request, response);
            }else {
                FilterChain.doFilter(request, response);
            }
        } catch (ServletException | IOException exception) {
            filterConfig.getServletContext().log(exception.getMessage());
        }

    }
}
