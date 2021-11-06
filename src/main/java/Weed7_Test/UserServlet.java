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

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<html>");
        printWriter.println("<head><title>UserServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>进入我的聊天系统</h3>");
        ServletContext servletContext = getServletContext();

        //判断用户
        if (servletContext.getAttribute("userlist") == null){
            Vector user_vector = new Vector();
            servletContext.setAttribute("userlist", user_vector);
        }

        //判断聊天信息
        if (servletContext.getAttribute("messagelist") == null){
            Vector message_vector = new Vector();
            servletContext.setAttribute("messagelist", message_vector);
        }

        printWriter.println("<form method='post' action='http://localhost:8999/MavenWeb_war/MainServlet'>" +
                "请输入你的名字: <input type='text' name='username'/>" +
                "<input type='submit' value='登录'/>" + "</form>");
        printWriter.println("</body>");
        printWriter.println("</hmtl>");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
