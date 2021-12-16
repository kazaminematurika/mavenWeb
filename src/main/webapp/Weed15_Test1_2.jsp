<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/16
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib uri="/CustomTags" prefix="simple"%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
    String username=request.getParameter("username");%>
<font size="4" color="blue">
    <simple:greetingAtt name="<%=username%>" />
</font>

</body>
</html>
