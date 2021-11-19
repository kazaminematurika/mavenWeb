<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/6
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weed10_Test1_3</title>
</head>

<%!
    String string = null;
    public void jspInit(){
        ServletConfig servletConfig = getServletConfig();
        string = servletConfig.getInitParameter("secret");
    }
%>

<body bgcolor="#e722ff">
<h1>计算器</h1>
    <%
    if(!string.equals(request.getParameter("pass"))){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Weed10_Test1_2.jsp");
        requestDispatcher.forward(request, response);
    }
    %>
<form method="post" action="Weed10_Test1_4.jsp">
    请输入表达式:<input type="text" name="expr">
    <input value="计算" type="submit">
</form>
</body>
</html>
