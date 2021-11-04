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
@WebServlet(name = "DispServlet", value = "/DispServlet")
public class DispServlet extends HttpServlet implements Servlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset = utf-8");
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<html>");
        printWriter.println("<head>" +
                "<meta http-equiv='refresh' content='3'><title>DispServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("内容:");
        ServletContext servletContext = getServletContext();
        Vector messageVector = (Vector) servletContext.getAttribute("messagelist");
        printWriter.println("<textarea name='info' rows='9'>");
        for (int i = 0; i < messageVector.size(); i++) {
            printWriter.println(messageVector.get(i));
        }
        printWriter.println("</textarea>");
        printWriter.println("用户列表:");
        printWriter.println("<textarea name='username' rows='9'>");
        Vector userVector = (Vector) servletContext.getAttribute("userlist");
        for (int i = 0; i < userVector.size(); i++) {
            printWriter.println(userVector.get(i));
        }

        printWriter.println("</textarea>");
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
