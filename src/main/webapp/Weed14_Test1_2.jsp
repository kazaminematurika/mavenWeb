<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/7
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed14_Test1_2</title>
</head>
<body>
<c:choose>
    <c:when test="${param.Language == 'zh_CN'}">
        <fmt:setLocale value = 'zh_CN'/>
        <fmt:setBundle basename="Language_zh_CN" var="zone" scope="session"/>
    </c:when>
    <c:when test="${param.Language == 'en_US'}">
        <fmt:setLocale value="en_US"/>
        <fmt:setBundle basename="Language_en_US" var="zone" scope="session"/>
    </c:when>
</c:choose>

<fmt:message bundle="${zone}" key="Label1" var="item" scope="page"/>
<h1>${item}</h1>
<form method="post" action="Weed14_Test1_3.jsp">
    <input type="text" name="inputData">(<fmt:message bundle="${zone}" key="Label2"/>)
    <br>
    <input type="submit" value="${item}">
</form>
</body>
</html>
