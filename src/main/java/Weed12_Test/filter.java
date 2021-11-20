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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain FilterChain) {
        //设置服务器最大被客户端请求得数值
        String paramVaule = filterConfig.getInitParameter("filterOff");
        try{
            //当客户端第一次请求了Weed12_Test1_1是hidden的参数times+1
            //此举动为记录当前服务器被同时访问的客户端
            String string = request.getParameter("times");
            if (string == null){
                //当请求不为空时为Weed12_Test1_1的param赋值(数值为:hidden当前的值)
                //此时利用request.getRequestDispatcher()方法请求分派到Weed12_Test1_1服务器并只保留请求头
                //Weed12_Test1_2的response不会显示到客户端中
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Weed12_Test1_1.jsp?param=" + paramVaule);
                requestDispatcher.forward(request, response);
            }else {
                FilterChain.doFilter(request, response);
            }
        } catch (ServletException | IOException exception) {
            filterConfig.getServletContext().log(exception.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
