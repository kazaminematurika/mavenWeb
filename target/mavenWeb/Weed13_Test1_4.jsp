<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/2
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed13_Test1_4</title>
    <style type="text/css">
        #oTable1{
            width: 200px;
            height: 100px;
            border: 1px solid #c0c0c0;
            text-align: center;
            font-size: 30px;
            /*设置表格边框模型*/
            border-collapse: collapse;
        }
        #oTable1 td{
            border: 1px solid #c0c0c0;
            font-size: 20px;
        }
    </style>
</head>
<body>
<h1>显示选择学生的信息</h1>
<table id="oTable1" class="">
    <tr>
        <td>&nbsp;</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>中国语</td>
        <td>数学</td>
        <td>国语</td>
    </tr>
    <%
        for (int i = 0; i <(request.getParameterValues("getInformationCheckbox")).length ; i++) {
            pageContext.setAttribute("i", (request.getParameterValues("getInformationCheckbox"))[i]);
        %>
    <td>${getStudent[i].name}</td>
    <td>${getStudent[i].age}</td>
    <td>${getStudent[i].gender}</td>
    <td>${getStudent[i].result[0]}</td>
    <td>${getStudent[i].result[1]}</td>
    <td>${getStudent[i].result[2]}</td>
    <%}%>
</table>
</body>
</html>
