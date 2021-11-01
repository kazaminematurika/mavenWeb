<%--
  Created by IntelliJ IDEA.
  User: Kazamine_Setueka
  Date: 2021/9/2
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");//记载数据库驱动，注册到驱动管理器
        String url="jdbc:mysql://localhost:3306/cs";  //根据自己的情况修改mysql数据库ip和端口，mysql是数据库上存在的一个库
        String username="root";   //登录账号
        String password="12345678";  //登录密码
        Connection conn= null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(conn!=null){
            System.out.println("OK!");
            try {
                ResultSet resultSet = null;
                conn = DriverManager.getConnection(url,username,password);
                Statement statement = conn.createStatement();
                resultSet = statement.executeQuery("select * from bmxx");
                while (resultSet.next()){
                    System.out.println(resultSet.getString("bmbh") + "\t" + resultSet.getString("bmmc"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("fail!");
        }
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
%>
</body>
</html>
