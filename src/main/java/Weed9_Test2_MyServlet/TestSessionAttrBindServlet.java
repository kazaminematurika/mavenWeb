package Weed9_Test2_MyServlet;

import Weed9_Test2_Listener_StuBean.StuBean;
import Weed9_Test2_MySQL.AccessDB;

import javax.servlet.Servlet;
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

@WebServlet(name = "TestSessionAttrBindServlet", value = "/TestSessionAttrBindServlet")
public class TestSessionAttrBindServlet extends HttpServlet implements Servlet {
    private static final String CONTEXT_TYPE = "text/html; charset = UTF-8";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTEXT_TYPE);
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        AccessDB accessDB = new AccessDB();
        printWriter.println("<html>");
        printWriter.println("<head><title>TestSessionAttrBindServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>测试对象绑定会话监听</h3>");
        printWriter.println("<form name = 'choose' method='post' action='http://localhost:8999/MavenWeb_war/UpdateDBServlet'>");
        printWriter.println("数据库记录信息:");
        //通过<select>HTML标签生成一个文本显示框并传递表单选择参数action到另一个网页中
        printWriter.println("<select name = 'select' size='10'>");
        Vector vector = accessDB.selectDB();
        for (int i = 0; i < vector.size(); i++) {
            //通过select子标签<option>创建一个select的选择内容标签
            printWriter.println("<option value=" + ((StuBean)vector.get(i)).getID() + ">");
            printWriter.println(vector.get(i).toString());
            printWriter.println("</option>");
        }
        printWriter.println("</select>");
        printWriter.println("<hr>");
        printWriter.println("<input type='submit' value='选择'>");
        printWriter.println("</form>");
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
