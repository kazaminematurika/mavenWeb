package Weed8_Test_Servlet;

import bsh.EvalError;
import bsh.Interpreter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
public class ResultServlet extends HttpServlet implements Servlet {
    private static final String CONTEXT_TYPE = "text/html; charset = UTF-8";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTEXT_TYPE);
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<head><title>ResultServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>过滤器过滤结果</h3>");
        Vector vector;
        vector = (Vector)getServletContext().getAttribute("result");
        String string = vector.elementAt(0).toString();
        printWriter.println(vector.get(0));
        for (int i = 1; i < vector.size(); i++) {
            string = string + vector.elementAt(i);
            printWriter.println(vector.get(i));
        }
        printWriter.println("<br>" + "计算出影射表达式的结果是:" + string);
        Interpreter bsh = new Interpreter();
            try{
                bsh.eval("Result = " + string);
                printWriter.println("=" + bsh.get("Result"));
            } catch (EvalError evalError) {
                printWriter.println("</body>");
                printWriter.println("</html>");
                printWriter.flush();
                printWriter.close();
            }
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
