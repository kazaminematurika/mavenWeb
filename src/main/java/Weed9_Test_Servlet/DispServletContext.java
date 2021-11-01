package Weed9_Test_Servlet;

import Weed9_Test_class.Dog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Kazamine_Setueka
 */
public class DispServletContext extends HttpServlet {
    private static final String CONTEXT_TYPE = "text/html; charset = UTF-8";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTEXT_TYPE);
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head><title>MyServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>创建上下文监听器</h3>");
        //获取指定对象的上下文相关属性
        Dog dog = (Dog) getServletContext().getAttribute("dogName");
        printWriter.println("dog's breed is:" + dog.getBreed());
        printWriter.println("<form method='post' action='http://localhost:8999/mavenWeb_war/DelServletContextAttribute'>" +
                "<input type='submit' value='删除上下文属性'>"+
                "</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
    }
}
