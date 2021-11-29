<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/19
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weed11_Test1_3</title>
</head>
<body>
<h1 style="text-align: center">你的订单号以及你购买商品的相关信息</h1>
<hr style="size: 5px; color: #ff0082">
<ol>
<%----%>
<%--<%<jsp:useBean id="Commodity" class="Weed11_Test.commodityBean" scope="session"/>&ndash;%&gt;--%>
<%--<jsp:setProperty name="Commodity" property="*"/>
<%--    Vector getCommodityVector = new Vector();--%>
<%--//    String getUserCommodityCheckbox =--%>
<%--    String[] getCommodityList = request.getParameterValues("getCommodity");--%>
<%--    for (int i = 0; i < getCommodityList.length; i++) {--%>
<%--        getCommodityVector.add(getCommodityList[i]);--%>
<%--    }--%>

<%--    commodityBean getCommodityBean = (commodityBean) session.getAttribute("Commodity");--%>
<%--    getCommodityBean.setVector(getCommodityVector);--%>
<%--%>--%>

<%--<%--%>
<%--    commodityBean outputCommodityBean = (commodityBean) session.getAttribute("Commodity");--%>
<%--    Vector outputCommodityVector = outputCommodityBean.getVector();--%>
<%--    if (outputCommodityVector != null){--%>
<%--        for (int i = 0; i < outputCommodityVector.size(); i++) {--%>
<%--            out.println(outputCommodityVector.get(i).toString());--%>
<%--            out.println("&nbsp;&nbsp;&nbsp;");--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
<%
    //订单号
long CommodityID = new Date().getTime();
Vector vector = new Vector();
//判空上下文对象分配订单号
if (application.getAttribute("CommodityID") == null){
    application.setAttribute("CommodityID", CommodityID);
}
double countCommodityPrice = 0;
%>

<%--判断用户选择了什么商品--%>
<%--    读取用户选择的choice那一整行的商品相关信息--%>
<%
    String CommodityList[] = request.getParameterValues("getCommodity");
    for (int i = 0; i < CommodityList.length; i++) {
        out.print("<hr>");
        String[] outputCommodityInformation = ((String) session.getAttribute(CommodityList[i])).split(",");

%>
<li>
    <%
        //    输出用户选择的商品以及商品的数量--
    String choiceCommdityAndNumber = outputCommodityInformation[0] + " " + outputCommodityInformation[1] + "数量:" + request.getParameter(CommodityList[i]);

    //循环计算每一样的价钱
    double price = Double.parseDouble(request.getParameter(CommodityList[i])) * Double.parseDouble(outputCommodityInformation[2]);

    //计算总价
    countCommodityPrice += price;

    out.print(choiceCommdityAndNumber + "合计:" + price);
    vector.add(choiceCommdityAndNumber + "合计:" + price);
    %>

</li>
<%
    }
//输出总价格及订单号
    out.print("<hr>你一共花费了:" + countCommodityPrice + "元");
    out.print("<hr>你的订单号是:" + CommodityID);
    out.print("<a = href = 'Weed11_Test_Main.jsp'>返回首页</a>");
    //保存订单号信息以及订单号ID
    application.setAttribute("CommodityID", CommodityID);
    application.setAttribute(String.valueOf(CommodityID), vector);
%>
</ol>
</body>
</html>

