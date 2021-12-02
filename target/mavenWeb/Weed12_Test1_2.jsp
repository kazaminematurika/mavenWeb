<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/20
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Weed12_Test1_2</title>
</head>
<body bgcolor="#f5f5dc">
  <%request.setCharacterEncoding("UTF-8");%>
<h1>学生信息注册</h1>
<hr style="color: hotpink ; size: 5px">
<form method="post" action="Weed12_Test1_3.jsp">
<%--  readonly作用生成一个提交表单的标记使其可以在input type = "submit"的这个按钮中同时提交具有相同readonly标签的表单信息
      action到指定的URL/JSP可以提交input中的多个表单的信息如:
      Name:<input type="text" name="email" />
      Country:<input type="text" name="country" value="China" readonly="readonly" />
      <input type="submit" value="Submit" />--%>
  <%
    String userName = request.getParameter("user");
    userName = new String(userName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
  %>
  用户名:<input type="text" name="user" value="<%=request.getParameter(userName)%>" readonly = "readonly">
  &nbsp;&nbsp;&nbsp;&nbsp;密码:<input type="password" name="password" value="<%=request.getParameter("password")%>" readonly = "readonly">
  <hr style="color: #ff0082 ; size: 5px">
  真实姓名:<input type="text" name="realName">
  <hr style="color: #f400ff ; size: 5px">
<%--  type="radio"为input标签的单选按钮属性使得相同name值的input只能选择一个--%>
  性别:&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="man">男性
  &nbsp;&nbsp;<input type="radio" name="gender" value="female">女性
  <br>
  <h1>你从哪知道本网站的主题</h1>
<%--  使用chenkbox属性使得拥有相同name的input标签都可以复选--%>
  <input type="checkbox" name="getType" value="Internet">互联网
  <input type="checkbox" name="getType" value="newspaper">报纸
  <input type="checkbox" name="getType" value="television">电视
  <hr style="color: #00f8ff ; size: 5px">
  <input type="submit" value="提交">
</form>
</body>
</html>
