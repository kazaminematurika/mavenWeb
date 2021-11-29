<%@ page import="java.util.Vector" %>
<%@ page import="Weed12_Test.userBean" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/11/20
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="Weed12_Test1_4.jsp" %>
<html>
<head>
    <title>Weed12_Test1_3</title>
</head>
<body bgcolor="#f5f5dc">
    <%request.setCharacterEncoding("UTF-8");%>
    <h1>学生信息登录</h1>
    <%--session表示将JavaBean实例对象存储在HttpSession对象中，
    存储在HttpSession对象中的JavaBean对象可以被属于同一个会话的所有Servlet和JSP页面访问，
    此设置要求当前JSP页面支持Session，即没有将page指令的session属性设置为false。也就是对一个特定用户有效，一个http会话。--%>
    <jsp:useBean id="student" class="Weed12_Test.userBean" scope="session"/>
    <%--    该形式是设置Bean 属性的快捷方式.在Bean 中属性的名字，类型必须和request对象中的参数名称相匹配。
        由于表单中传过来的数据类型都是String 类型的，Jsp内在机制会把这些参数转化成Bean属性对应的类型。
        property = "*"表示所有名字和Bean属性名字匹配的请求参数都将被传递给相应的属性set方法--%>
    <jsp:setProperty name="student" property="*"/>
<%
  Vector getTypeVector = new Vector();
  String[] getTypeList = request.getParameterValues("getType");
  //创建一个集合使得在Weed12_Test1_2提交Name=getType(被数组包装着)提交到此的信息被存放到集合中
  for (int i = 0; i < getTypeList.length; i++) {
        getTypeVector.add(getTypeList[i]);
  }
  userBean getTypeUserBean = (userBean) session.getAttribute("student");
  /*1.jsp:useBean id=“”和jsp:setProperty name=“” 要一致
  * 2.jsp:useBean scope=“”指定了getAttribute需要用到哪一个Javabean
  * 3.在此处及下文调用了Javabean关于集合的setter和getter方法*/
  getTypeUserBean.setVector(getTypeVector);
%>

    <hr style="color: #ff0082 ; size: 5px">
<%--    property的数值必需要和用的Javabean保持一致--%>
    用户名:<jsp:getProperty name="student" property="user"/><br>
<%--    <jsp:getProperty name="student" property="gender"/>  --%>
    密码:<jsp:getProperty name="student" property="password"/><br>
    姓名:<jsp:getProperty name="student" property="realName"/><br>
    性别:<jsp:getProperty name="student" property="gender"/><br>
    <h1>你从哪里知道本网站的主题</h1>
    <%
      userBean outputUserBean = (userBean) session.getAttribute("student");
      Vector outputTypeVector = outputUserBean.getVector();
      if (outputTypeVector != null) {
        for (int i = 0; i < outputTypeVector.size(); i++) {
          out.println(outputTypeVector.get(i).toString());
          out.println("&nbsp;&nbsp;&nbsp;");
        }
      }
    %>
</body>
</html>
