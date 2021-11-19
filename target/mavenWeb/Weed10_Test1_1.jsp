<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/6
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Weed10_Test1_1</title>
</head>

<script language="JavaScript" type="text/javascript">
    function checkMyFrom() {
        var text = MyFrom.pass.value();
        if (!(checkNumber(text))){
            alert("密码输入框只能输入数字");
            return false;
        }else {
            return true;
        }
    }

    function checkNumber(String) {
        var Letter = "1234567890";
        var c;
        for (var i = 0; i < String.length; i++) {
            c = String.charAt(i);
            if (Letter.indexOf(c) === -1){
                return false;
            }else {
                return true;
            }
        }
    }
</script>
<body bgcolor="#e722ff">
    <form name="MyForm" method="post" action="Weed10_Test1_3.jsp" onsubmit="return checkMyFrom()">
        请输入密码:<input name="pass" type="password">
        <input value="登录" type="submit">
    </form>
</body>
</html>
