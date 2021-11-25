<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/25
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JNDITest</title>
</head>
<body>
<table border="1">
    <tr>学号</tr>
    <tr>姓名</tr>
    <tr>语文</tr>
    <tr>数学</tr>
    <tr>英语</tr>

    <%
        Context contextInitial = new InitialContext();
        //tomcat固定的查找入口"java:comp/env"
        Context contextProtocol = (Context) contextInitial.lookup("java:comp/env");
        DataSource dataSource = (DataSource) contextProtocol.lookup("KazamineSetueka");
        Connection connection = dataSource.getConnection();
        try {
            if (connection != null){
                System.out.println("tomcatJNDI链接数据库成功");
                Connection connectionDatabase = dataSource.getConnection();
                Statement statement = connection.createStatement();
                String sql = "select * from weed5_test";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){%>
            <tr>
                <td><%resultSet.getString("ID");%></td>
                <td><%resultSet.getString("Name");%></td>
                <td><%resultSet.getString("Chinese");%></td>
                <td><%resultSet.getString("Math");%></td>
                <td><%resultSet.getString("English");%></td>
            </tr>
                <%}
                connectionDatabase.close();
                statement.close();
            }else {
                    System.out.println("tomcatJNDI链接数据库失败");
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }%>

</table>
</body>
</html>
