package Weed9_Test2_MySQL;

import Weed9_Test2_Listener_StuBean.StuBean;

import java.sql.*;
import java.util.Vector;

/**
 * @author Kazamine_Setueka
 */
public class AccessDB {
    int ID;
    Vector vector;

    public AccessDB(){
        vector = new Vector();
    }

    public AccessDB(int inputID) {
        ID = inputID;
        vector = new Vector();
    }

    public Vector selectDB(){
        String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
        String user = "root";
        String password = "12345678";

        Connection connection;
        Statement mystatement;
        ResultSet myresultSet;
        String sql = "select * from Weed5_Test";
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection(url, user, password);
            mystatement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            myresultSet = preparedStatement.executeQuery();
            while (myresultSet.next()){
                vector.add(new StuBean(myresultSet.getInt("ID"), myresultSet.getString("Name"), myresultSet.getInt("Chinese")
                , myresultSet.getInt("Math"), myresultSet.getInt("English")));

            }
            myresultSet.close();
            mystatement.close();
            connection.close();
            return vector;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //通过查询学生的学号获取该学生的数据记录

    public StuBean selectDBByid(){
        String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
        String user = "root";
        String password = "12345678";
        StuBean stuBean = null;

        Connection connection;
        Statement mystatement;
        ResultSet myresultSet;
        String sql = "select * from Weed5_Test where ID = ?";
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection(url, user, password);
            mystatement = connection.createStatement();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            myresultSet = preparedStatement.executeQuery();
            while (myresultSet.next()){
               stuBean = new StuBean(myresultSet.getInt("ID"), myresultSet.getString("Name"),
                       myresultSet.getInt("Chinese"), myresultSet.getInt("Math"), myresultSet.getInt("English"));
            }
            myresultSet.close();
            mystatement.close();
            connection.close();
            return stuBean;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    //通过学号修改学生的其中的一科成绩，现在以修改数学成绩作为Test测试

    public String updateDB(int test){
        String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
        String user = "root";
        String password = "12345678";
        StuBean stuBean = selectDBByid();

        Connection connection;
        Statement mystatement;
        PreparedStatement preparedStatement;

        String sql = "update weed5_test set math = ? where ID = ?";
        if (stuBean.getMath() != test){
             try{
                 connection = DriverManager.getConnection(url, user, password);
                 mystatement = connection.createStatement();
                 preparedStatement = connection.prepareStatement(sql);
                 preparedStatement.setInt(1, test);
                 preparedStatement.setInt(2, ID);
                 int row = preparedStatement.executeUpdate();
                 if (row != 0){
                     System.out.println("数据修改完成....");
                     preparedStatement.close();
                     mystatement.close();
                     connection.close();
                     return "修改数据完成....";
                 }else {
                     preparedStatement.close();
                     mystatement.close();
                     connection.close();
                     return "数据修改失败";
                 }
             } catch (SQLException throwables) {
                 throwables.printStackTrace();
             }
             return null;
        }else {
            return "成绩没有改变,无需修改";
        }
    }
}
