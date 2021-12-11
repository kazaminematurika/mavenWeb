<%@ page import="Weed13_Test.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/12/2
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Weed13_Test1_3</title>
    <style type="text/css">
        #oTable1{
            width: 200px;
            height: 100px;
            border: 1px solid #c0c0c0;
            /*text-align: center;*/
            font-size: 30px;
            /*设置表格边框模型*/
            /*border-collapse: collapse;*/
            white-space: nowrap;
        }
        #oTable1 td{
            border: 1px solid #c0c0c0;
            font-size: 20px;
            white-space: nowrap;
        }
    </style>
<%--    <script type="text/javascript">--%>
<%--        function show() {--%>
<%--        obj.firstChild.firstChild.checked =! obj.firstChild.firstChild.checked;--%>
<%--        obj.style.backgroundColor = obj.firstChild.firstChild.checked ? "yellow" : "#FFFFFF";--%>
<%--    }--%>
<%--    </script>--%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function (){
            $("input[name = 'getInformationCheckbox']").bind("click", function (){
                if($(this).attr("checked")){
                    $(this).parent().parent().attr.css("background", "yellow");
                }else {
                    $(this).parent().parent().removeAttr.css("background");
                }
            });
        });
    </script>
</head>
<%--直接实例化对呀JavaBean类的3个对象--%>
<%
    StudentBean studentBean1 = new StudentBean("朱雀-红叶", 18, "女",new int[]{90, 90, 90});
    StudentBean studentBean2 = new StudentBean("风岭-雪月花", 18, "女",new int[]{80, 80, 80});
    StudentBean studentBean3 = new StudentBean("风岭-茉莉花", 18, "女",new int[]{85, 85, 85});
//    创建一个对象数组用于存放上述已被实例化的对象
    StudentBean[] studentBeanList = {studentBean1, studentBean2, studentBean3};
//    设置该网页的上下文属性对象
    session.setAttribute("getStudent", studentBeanList);
%>
<body>
<form method="post" action="Weed13_Test1_4.jsp">
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
            for (int i = 0; i < ((StudentBean[])session.getAttribute("getStudent")).length; i++) {
                pageContext.setAttribute("i", new Integer(i));

        %>
<%--        <tr onclick="show(this)">--%>
        <tr>
            <td><input type="checkbox" name="getInformationCheckbox" value="<%=i%>"></td>
            <td>${getStudent[i].name}</td>
            <td>${getStudent[i].age}</td>
            <td>${getStudent[i].gender}</td>
            <td>${getStudent[i].result[0]}</td>
            <td>${getStudent[i].result[1]}</td>
            <td>${getStudent[i].result[2]}</td>
        </tr>
        <%}%>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
