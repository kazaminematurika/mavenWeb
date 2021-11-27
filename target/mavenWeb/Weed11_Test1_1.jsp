<%@ page import="java.sql.*" %><%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/27
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Weed11_Test1_1</title>
</head>
<body bgcolor="#ff69b4">
<form action="Weed11_Test1_3.jsp">
    <table border="1">
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>商品单价</td>
            <td>商品数量</td>
            <td>是否加入购物车</td>
        </tr>

        <%
            String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
            String user = "root";
            String password = "12345678";

            Connection connection;
            Statement mystatement;
            ResultSet myresultSet;
            String selectSQL = "select * from Weed11_Test";
//            String insertSQL = "insert into Weed11_Test2 value =?";
            try{
                connection = DriverManager.getConnection(url, user, password);
                mystatement = connection.createStatement();
                myresultSet = mystatement.executeQuery(selectSQL);
                while (myresultSet.next()){
        %>
        <tr>
            <td><%=myresultSet.getString("ID")%></td>
            <td><%=myresultSet.getString("Name")%></td>
            <td><%=myresultSet.getString("price")%></td>
            <%--       maxlength属性为input输入框可以输入的最大字符串值 ,现在为0-10 --%>
            <td><input type="text" size="3" style="text-align: center" maxlength="10"></td>
<%--            <td><input type="checkbox" name="getCommodity"></td>--%>

            <td><input type="checkbox"></td>
        </tr>
        <%}
                connection.close();
                mystatement.close();
                myresultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        %>
    </table>
<%--    <input type="hidden" value="1" name="OrderID">--%>
    <input type="submit" value="提交订单">
</form>
</body>
</html>
