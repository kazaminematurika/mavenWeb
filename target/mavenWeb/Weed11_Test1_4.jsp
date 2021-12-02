<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/19
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weed11_Test1_4</title>
</head>
<body>
<%
//获取查询的订单号
    String CommodityID = request.getParameter("CommodityID");
    if (application.getAttribute(CommodityID) != null){
        out.print("订单号:" + CommodityID + "<br><br>");
        out.print("商品编号:&nbsp;&nbsp;&nbsp;&nbsp;" + "商品名称:&nbsp;&nbsp;&nbsp;&nbsp;" +
                "商品单价:&nbsp;&nbsp;&nbsp;&nbsp;" + "商品数量:&nbsp;&nbsp;&nbsp;&nbsp;");
        Vector vector = (Vector) application.getAttribute(CommodityID);
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()){
            //迭代输出
            out.print("<hr>" + iterator.next() + "<hr>");
        }
        out.println("<a href = 'Weed11_Test_Main.jsp'>返回首页</a>");
    }else {
        out.print("没有此订单");
        out.println("<a href = 'Weed11_Test_Main.jsp'>返回首页</a>");
    }
%>
</body>
</html>
