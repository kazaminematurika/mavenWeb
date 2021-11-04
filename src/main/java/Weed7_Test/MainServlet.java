package Weed7_Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet implements Servlet {
    private static final String CONTEXT_TYPE = "text/html; charset = utf-8";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType(CONTEXT_TYPE);
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<html>");
        printWriter.println("<head><title>MainServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>进入聊天系统</h3>");
        ServletContext servletContext = getServletContext();
        Vector vector = (Vector) servletContext.getAttribute("userlist");
        String username = request.getParameter("username");
        //使用ISO_8859_1反编码令客户端的数据转化为二进制然后再从UTF-8中逐一寻找匹配的字串符
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        vector.add(username);
//        getRequestDispatcher中的参数需要使用相对路径
//        path中的参数符合HTML以及Servlet表达式不能使用空格分割表达式
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/MessageServlet?username=" + username);
        requestDispatcher.forward(request, response);
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
