<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/3
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Weed10_Test1_1</title>
</head>
<script language="JavaScript" type="text/javascript">
    function checkNumber() {
        var Latters = "0123456789";
        var c;
        for (var i = 0; i < String.length; i++) {
            c = String.charAt(i);
        }if (Latters.indexOf(c) === -1){
            return false;
        }else {
            return true;
        }
    }

    function LoginTextType() {
        var text = myForm.pass.value();
        if (!checkNumber(text)){
            alert("输入框只能输入数字");
            return false;
        }else {
            return true
        }
    }
</script>
<body bgcolor="#f5f5dc">
<h1>登录系统</h1>
</body>
<form name="myForm" method="post" action="Test1_2.jsp" onsubmit="return LoginTextType()">
    <input type="password" name="pass">
    <input type="submit" value="登录">
</form>
</html>
