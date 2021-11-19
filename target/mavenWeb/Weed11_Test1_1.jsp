<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/16
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Weed11_Test1_1</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
<body>
<form action="">
    <table border="1"><tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品数量</td>
        <td>购物篮</td>
        </tr></table>
</form>

<%
    String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
    String user = "root";
    String password = "12345678";

    Connection connection;
    Statement mystatement;
    ResultSet myresultSet;
    String sql = "select * from Weed11_Test";
    try {
        connection = DriverManager.getConnection(url, user, password);
        mystatement = connection.createStatement();
        myresultSet = mystatement.executeQuery(sql);
        while (myresultSet.next()){
            myresultSet.getString("ID");
            myresultSet.getString("name");
            myresultSet.getString("price");
            myresultSet.getString("quantity");
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
%>
</body>
</html>
