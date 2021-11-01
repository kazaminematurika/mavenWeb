package Weed6_Test;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet implements Servlet {
    private static final String CONTEXT_TYPE = "text/html; charset=utf-8";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTEXT_TYPE);
        PrintWriter printWriter = response.getWriter();
        request.setCharacterEncoding("utf-8");
        printWriter.println("<HTML>");
        printWriter.println("<HEAD><TITLE>StudentServlet</TITLE></HEAD>");
        printWriter.println("<body bgcolor = \"#ffffff\">");
        if ((request.getParameter("StudentID")) == null || request.getParameter("StudentID").equals("Input number")){
            //method为浏览器的表单向服务器传递信息,POST(安全性,实数多性),GET(实数比较少)参数,action的参数为接受提交表单的服务器的名称
            //判断用户输入数值以维持当前界面还是输出结果
            printWriter.println("<Form method = 'post' action = 'http://localhost:8999/mavenWeb_war/StudentServlet'>");
            printWriter.println("学生学号<input type = 'text' name = 'StudentID' value = 'Input number'/>");
            //创建提交表单数据的按钮
            printWriter.println("<input type = 'submit' value = '查询'/><br>");
            printWriter.println("</FORM>");

        }
        else if (!(request.getParameter("StudentID").equals("Input number"))){
            Vector vector;
            printWriter.println("<Form method = 'post' action = 'http://localhost:8999/mavenWeb_war/StudentServlet'>");
            printWriter.println("学生学号<input type = 'text' name = 'StudentID'/>");
            //创建提交表单数据的按钮
            printWriter.println("<input type = 'submit' value = '查询'/><br>");
            printWriter.println("</FORM>");
            printWriter.println("<hr>");
            printWriter.println("<table border = '1'><tr>");
            //th标签定义表头
            printWriter.println("<tr><th>学号</th>" +
                                "<th>姓名</th>" +
                                "<th>语文</th>" +
                                "<th>数学</th>" +
                                "<th>英语</th></tr>" );

            try{
                if ((vector = accessDB(Integer.parseInt(request.getParameter("StudentID")))) != null){
                    printWriter.println("<tr>");
                    printWriter.println("<td>" + vector.elementAt(0) +"</td>");
                    printWriter.println("<td>" + vector.elementAt(1) +"</td>");
                    printWriter.println("<td>" + vector.elementAt(2) +"</td>");
                    printWriter.println("<td>" + vector.elementAt(3) +"</td>");
                    printWriter.println("<td>" + vector.elementAt(4) +"</td>");
                    printWriter.println("</tr>");
                }
            } catch (Exception e) {
                printWriter.println("<tr>");
                printWriter.println("<th colspan='5'>没有记录</th>");
                printWriter.println("</tr>");
            }
                printWriter.println("</table>");
                printWriter.println("</BODY>");
                printWriter.println("</HTML>");
                printWriter.flush();
                printWriter.close();
        }
    }

    private Vector<String> accessDB(int StudentID){
        String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
        String user = "root";
        String password = "12345678";

        Vector<String> vector = new Vector<>();
        Connection connection;
        Statement mystatement;
        ResultSet myresultSet;
        String sql = "select * from Weed5_Test where ID = ?";
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection(url, user, password);
            mystatement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, StudentID);
            myresultSet = preparedStatement.executeQuery();
            while (myresultSet.next()){
                vector.add(Integer.toString(myresultSet.getInt("ID")));
                vector.add(myresultSet.getString("Name"));
                vector.add(Integer.toString(myresultSet.getInt("Chinese")));
                vector.add(Integer.toString(myresultSet.getInt("Math")));
                vector.add(Integer.toString(myresultSet.getInt("English")));
                }
            myresultSet.close();
            mystatement.close();
            connection.close();
            return vector;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

