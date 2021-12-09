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
<%--            <td><input name="ID" value="<%=myresultSet.getString("ID")%>"></td>--%>
<%--            <td><input name="Name" value="<%=myresultSet.getString("Name")%>"></td>--%>
<%--            <td><input name="price" value="<%=myresultSet.getString("price")%>"></td>--%>
            <%--       maxlength属性为input输入框可以输入的最大字符串值, minlength为可以输入的最小字符串的数值 --%>
            <td><%=myresultSet.getInt("ID")%></td>
            <td><%=myresultSet.getString("Name")%></td>
            <td><%=myresultSet.getString("price")%></td>
<%--    设置input的name的value,部署到对象上下文中使用request.getparameter(value)获取input里面的数值--%>
            <td><input type="text" size="3" style="text-align: center" maxlength="<%=myresultSet.getInt("quantity")%>" minlength="0" value="0" name="<%=myresultSet.getInt("ID")%>"></td>
            <td><input type="checkbox" name="getCommodity" value="<%=myresultSet.getInt("ID")%>"></td>

<%--            <td><input type="checkbox"></td>--%>
        </tr>
        <%
                    //将每条商品的信息保存在对象会话中,key为商品的ID, value为商品的每一天信息
                session.setAttribute(String.valueOf(myresultSet.getInt("ID")), myresultSet.getInt("ID") + "," + myresultSet.getString("Name") + "," + myresultSet.getString("price"));
                }
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
<%--    <%--%>

<%--    %>--%>
</form>
</body>
</html>
