<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/6
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="bsh.*" %>
<html>
<head>
    <title>Weed10_Test1_4</title>
</head>
<body bgcolor="#e722ff">
<h1>计算结果</h1>
<%
try {
    Interpreter interpreter = new Interpreter();
    interpreter.eval("el=" + request.getParameter("expr"));
    out.println(request.getParameter("expr") + "=");
    out.println(interpreter.get("el"));
}catch (Exception exception){
    exception.printStackTrace();
}
%>
</body>
</html>
