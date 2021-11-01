package Weed5_Test;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Kazamine_Setueka
 */

@WebServlet(name = "FromServlet", value = "/FromServlet")
public class FromServlet extends HttpServlet implements Servlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<HTML>");
        printWriter.println("<HEAD><TITLE>Servlet_Test</TITLE>");
        printWriter.println("<BODY>");
        printWriter.println("<p>Please input a from</p>");
//        printWriter.println("<FORM method='POST' action='http://localhost:8999/mavenWeb_war/FromServlet'>");
        printWriter.println("<FORM method='POST' action='http://localhost:8999/mavenWeb_war/responseservelt'>");
        printWriter.println("用户名:<input type='text' name='username'/><br>");
        printWriter.println("密码:&nbsp;&nbsp;<input type='password' name='password'/><br>");
        printWriter.println("<input type='Submit' value='提交'/><br>");
        printWriter.println("</FROM>");
        printWriter.println("</BODY>");
        printWriter.println("</HTML>");
//        printWriter.println("<p>用户名:" + request.getParameter("username") + "</p>");
//        printWriter.println("<p>密码:" + request.getParameter("password") + "</p>");
        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doGet(request, response);

    }

}
