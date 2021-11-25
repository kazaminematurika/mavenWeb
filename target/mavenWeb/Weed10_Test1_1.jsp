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
    // function checkMyFrom() {
    //     var text = MyFrom.pass.value();
    //     if (!(checkNumber(text))){
    //         alert("密码输入框只能输入数字");
    //         return false;
    //     }else {
    //         return true;
    //     }
    // }
    //
    // function checkNumber(String) {
    //     var Letter = "1234567890";
    //     var c;
    //     for (var i = 0; i < String.length; i++) {
    //         c = String.charAt(i);
    //         if (Letter.indexOf(c) === -1){
    //             return false;
    //         }else {
    //             return true;
    //         }
    //     }
    // }

    function check(){
        var value = document.getElementById("password").value;
        //使用正则表达式进行判断input输入的是否全为数字
        // 注意：故意限制了 0321 这种格式，如不需要，直接reg=/^\d+$/;
        //var reg= /^[1-9]\d*$|^0$/;
        //限制用户只能输入非负的整数
        var reg = /^[1-9]\d*|0$/;
        //getElementById(Value)必须要与需要判断的ID="Value"所对应而且getElementById需要唯一对应某一个ID
        if(reg.test(value)===true){
            alert("都是数字！密码通过");
            return true;
        }else{
            alert("密码输入框中只能输入数字!");
            return false;
        }
    }
</script>
<body bgcolor="#e722ff">
    <form method="post" action="Weed10_Test1_3.jsp" onsubmit="check()">
        请输入密码:<input name="pass" type="password" id="password">
        <input value="登录" type="submit">
    </form>
</body>
</html>
