<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/18
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Weed12_Test1_1</title>
</head>
<body bgcolor="#f5f5dc">
<h1>登录信息</h1>
<%
    String parameter = request.getParameter("param");
    String configInitParameter = config.getInitParameter("jspOff");
    if (parameter != null && (parameter.equals(configInitParameter))){
%>
<form method="post" action="Weed12_Test1_2.jsp">
    用户名:<input type="text" name="user">
    密码:<input type="password" name="password">
<%--    使用input type="hidden" name="times" value="1"
        使得每一个新的用户登录进入服务器后服务器的人数都会自加1,
        而这个动作不会被用户看到,typr = "hidden" 隐式--%>
    <input type="hidden" name="times" value="1">
    <hr style="color: hotpink ; size: 5px">
    <input type="submit" value="提交">
</form>

<%}else {%>

<%--无参数时直接跳转页面如:jsp:forward = page = "需要跳转的URL/JSP"--%>
<%--有参数时可以把参数一起提交到需要跳转的URL/JSP界面中
    如:<jsp:forward page="login.jsp">
      <jsp:param name="username" value="root"/>
      </jsp:forward>
      此段代码为提交了username的参数值为:root给login的这个JSP
--%>
<jsp:forward page="Weed12_Test1_4.jsp"/>

<%}%>

</body>
</html>
