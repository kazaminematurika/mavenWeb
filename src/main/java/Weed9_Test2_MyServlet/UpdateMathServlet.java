package Weed9_Test2_MyServlet;

import Weed9_Test2_Listener_StuBean.StuBean;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Kazamine_Setueka
 */

@WebServlet(name = "UpdateMathServlet", value = "/UpdateMathServlet")
public class UpdateMathServlet extends HttpServlet implements Servlet {
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
        printWriter.println("<head><title>UpdateMathServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        printWriter.println("<h3>修改数学成绩完成</h3>");
        HttpSession httpSession = request.getSession();
        //通过httpSession.getAttribute（影射名）来引用之前通过getAttribute 绑定的对象
        //通过被绑定对象传递input的参数
        StuBean stuBean = (StuBean) httpSession.getAttribute("stuBean");
        if (request.getParameter("Math") != null) {
            stuBean.setMath(Integer.parseInt(request.getParameter("Math")));
            //通过销毁被绑定对象来调用valueUnbound接口方法传递了第二个参数给类AccessDB中UpdataDB方法的参数
            httpSession.removeAttribute("stuBean");
        }
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
