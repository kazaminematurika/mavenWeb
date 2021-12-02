<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/2
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed13_Test1_1</title>
</head>
<body>
<h1 style="text-align: center">九九乘法表</h1>
<%--属性cellspacing为设置单元格之间的空白量, 属性cellpadding为设置单元格内文本与单元格之间的空白量--%>
<table border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td bgcolor="yellow">*</td>
        <td bgcolor="grey">1</td>
        <td bgcolor="grey">2</td>
        <td bgcolor="grey">3</td>
        <td bgcolor="grey">4</td>
        <td bgcolor="grey">5</td>
        <td bgcolor="grey">6</td>
        <td bgcolor="grey">7</td>
        <td bgcolor="grey">8</td>
        <td bgcolor="grey">9</td>
    </tr>
    <%
        for (int i = 0; i < 9; i++) {
//            设置对象上下文属性
            pageContext.setAttribute("i", new Integer(i));

    %>
    <tr>
        <td bgcolor="gray">
<%--            使用EL表达式获取JSP脚本的数值--%>
            ${i+1}
        </td>
        <%
            for (int k = 0; k < 9; k++) {
                pageContext.setAttribute("k", new Integer(k));
        %>

        <td>
            ${(i + 1)*(k + 1)}
        </td>

        <% } %>

    </tr>

    <% }%>
</table>
</body>
</html>
