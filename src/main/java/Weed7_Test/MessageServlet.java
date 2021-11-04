package Weed7_Test;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
@WebServlet(name = "MessageServlet", value = "/MessageServlet")
public class MessageServlet extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<html>");
        printWriter.println("<head><title>MessageServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");

        ServletContext servletContext = getServletContext();
        String username = request.getParameter("username");
//        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String message = request.getParameter("message");
//        message = new String(message.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Vector vector = (Vector) servletContext.getAttribute("messagelist");
        if (message != null) {
            vector.add(username + ":" + message);
        }
        printWriter.println("<iframe frameborder = 0 height = 146 marginheight = 0 marginwidth = 0 " +
                "scrolling='auto' src='http://localhost:8999/mavenWeb_war/DispServlet' width='100%' height = '80%'>" + "</iframe>");
//        action跳转表达式的赋值符号不能使用空格进行分割,而且跳转表达式需要与之前的request.getRequestDispatcher(path)中的path参数的表达式相对应
        printWriter.println("<form method='post' action='http://localhost:8999/mavenWeb_war/MessageServlet?username=" + username + "'>");
        printWriter.println("<hr>");
        printWriter.println("请输入信息:<input type='text' name='message'>");
        printWriter.println("<input type='submit' value='发送'></from>");
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
