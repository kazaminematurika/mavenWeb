package Weed5_Test;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


/**
 * @author Kazamine_Setueka
 */

@WebServlet(name = "responseservelt", value = "/responseservelt")
public class responseservelt extends HttpServlet implements Servlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter printWriter = response.getWriter();
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    username = new String (username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) ;
    String password = request.getParameter("password");
    password = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    printWriter.println("<HTML>");
    printWriter.println("<HEAD><TITLE>responseservelt_Test</TITLE></HEAD>");
    printWriter.println("<BODY bgcolor=\"#ffffff\">");
//    printWriter.println("<p>用户名:" + request.getParameter("username") + "</p>");
//    printWriter.println("<p>密码:" + request.getParameter("password") + "</p>");
        printWriter.println("<p>用户名:" + username + "</p>");
        printWriter.println("<p>密码:" + password + "</p>");
    printWriter.println("</BODY>");
    printWriter.println("</HTML>");
    printWriter.flush();
    printWriter.close();
}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        doGet(request, response);
    }

}
