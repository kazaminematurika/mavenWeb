package Weed8_Test_Servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Kazamine_Setueka
 */
public class MyServlet extends HttpServlet implements Servlet {
    private static final String CONTEXT_TYPE = "text/html; charset = UTF-8";

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTEXT_TYPE);
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>\n" +
                "<head><title>MyServlet</title></head>\n" +
                "<body bgcolor='#f5f5dc'>\n" +
                "<form method='post' action='http://localhost:8999/mavenWeb_war/ResultServlet'>\n" +
                "    请输入一个数字:<input type='text' name='param'>\n" +
                "    <input type='submit' value='确定'>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
