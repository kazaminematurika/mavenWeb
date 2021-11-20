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
        /*调用jsoInit内部函数接口设置一个JSP一次性的初始值,
        * 在Web.XML中利用init-param标签设置
        * 其中param-name标签要和ServletConfig.getInitParameter()
        * 中的参数的名字保持一致
        * param-value则是初始化的数值*/
        ServletConfig servletConfig = getServletConfig();
        string = servletConfig.getInitParameter("secret");
    }
%>

<body bgcolor="#e722ff">
<h1>计算器</h1>
    <%
    if(!string.equals(request.getParameter("pass"))){
        /*request.getRequestDispatcher方法设置了响应体(URL/JSP)
        * forward()时只会把上述被响应服务器的response反应给客户端
        * 而请求的响应的Servlet不会响应,而include则是可以把被请求得Servlet
        * 得response以及自身得一起从请求服务器发送到客户端*/
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
