<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/2
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed13_Test1_2</title>
</head>
<body>
<h1>计算五门学科的平均分</h1>
<br>
<form action="Weed13_Test1_2.jsp" method="post">
    <table>
        <tr><td>请输入英语分数:</td>
        <td><input name="English" size="5" maxlength="3" type="text" value="${param.English}"/>
            <b>/100</b>
        </td></tr>

        <tr><td>请输入数学分数:</td>
            <td><input name="Math" size="5" maxlength="3" type="text" value="${param.Math}"/>
                <b>/100</b>
            </td></tr>

        <tr><td>请输入历史分数:</td>
            <td><input name="History" size="5" maxlength="3" type="text" value="${param.History}"/>
                <b>/100</b>
            </td></tr>

        <tr><td>请输入化学分数:</td>
            <td><input name="Chemical" size="5" maxlength="3" type="text" value="${param.Chemical}"/>
                <b>/100</b>
            </td></tr>

        <tr><td>请输入地理分数:</td>
            <td><input name="Geography" size="5" maxlength="3" type="text" value="${param.Geography}"/>
                <b>/100</b>
            </td></tr>

        <tr><td> 总分:</td>
            <td>${(param.English + param.Math + param.History + param.Chemical + param.Geography) / 500}</td>
        </tr>

        <tr><td> 平均分:</td>
            <td>${(param.English + param.Math + param.History + param.Chemical + param.Geography) / 5}</td>
        </tr>

        <tr><td><td><input value="提交" type="submit"/></td></tr>
    </table>
</form>
</body>
</html>
