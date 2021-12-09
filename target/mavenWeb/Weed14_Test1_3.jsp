<%@ page import="java.util.Vector" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/7
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed14_Test1_3</title>
</head>
<body>
<h1><fmt:message bundle="${zone}" key="Label1"/></h1>
<%!
    String string(Vector vector){
        return vector.toString();
    }
    int getMaxNumber(Vector vector){
        int temp = 0;
        try {
            temp = Integer.parseInt((String) vector.get(0));
            for (int i = 0; i < vector.size(); i++) {
                if (temp < Integer.parseInt((String) vector.get(i))){
                    temp = Integer.parseInt((String) vector.get(i));
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return temp;
    }
%>

<%Vector vector = new Vector();%>
<c:forTokens items="${param.inputData}" delims="," var="item" varStatus="">
    <c:set var="value" value="${item}" scope="page"/>
    <%
        String string = (String) pageContext.getAttribute("value");
        vector.add(string);
    %>
</c:forTokens>
<%string(vector);%>
<br>
<fmt:message bundle="${zone}" key="Label1"/>
&nbsp;
<%getMaxNumber(vector);%>
</body>
</html>
