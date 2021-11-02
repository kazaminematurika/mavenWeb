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

@WebServlet(name = "UpdateDBServlet" , value = "/UpdateDBServlet")
public class UpdateDBServlet extends HttpServlet implements Servlet {
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
        printWriter.println("<head><title>UpdateDBServlet</title></head>");
        printWriter.println("<body bgcolor='#f5f5dc'>");
        //在监听类中<select>通过name = 'select' 传递了通过选择按钮传递的表单参数
        //通过在接口方法中实例化了类StuBean以及类AccessDB以及调用了selectDBByid方法
        // 使得能够准确的输出用户在第一个界面中选择的内容，通过ID查询数据库里面的内容
        //在类StuBean 被new（实现）则会实现valueBound接口方法（HttpSessionBindingListener）链接了接口
        StuBean stuBean = new StuBean(Integer.parseInt(request.getParameter("select")));
        //使用request.getSession();创建一个临时的被绑定对象存放器
        //通过httpSession.setAttribute(’影射名‘, 传递的对象值)来设置被绑定对象需要传递的参数
        HttpSession httpSession  = request.getSession();
        httpSession.setAttribute("stuBean", stuBean);
        printWriter.println("<form method='post' action='http://localhost:8999/mavenWeb_war/UpdateMathServlet'>");
        printWriter.println("学号:" + stuBean.getID() + "姓名:" + stuBean.getName() + "语文:" + stuBean.getChinese() + "数学:" + stuBean.getMath() + "英语:" + stuBean.getEnglish());
        printWriter.println("修改数学成绩入口");
        printWriter.println("<input type='text' name='Math' value=" + stuBean.getMath() + ">");
        printWriter.println("<input type='submit' value='修改数学成绩'>");
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
