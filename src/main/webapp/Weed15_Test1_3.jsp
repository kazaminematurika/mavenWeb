<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/16
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib  prefix="triangle" uri="/TriangleTags"%>--%>
<html>
<head>
    <title>Weed15_Test1_3</title>
</head>
<BODY BGCOLOR=cyan><FONT Size=3>
    <P> 请输入三角形的三个边的长度，输入的数字用逗号分割：
        <BR>

    <FORM action="" method=post name=form>
        <INPUT type="text" name="sides" value="${param.sides}">
        <INPUT TYPE="submit" value="送出" name=submit>
    </FORM>
    <triangle:showMessage sides="${param.sides}" />

</body>
</html>
