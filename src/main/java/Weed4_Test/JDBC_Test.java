package Weed4_Test;

import java.sql.*;

public class JDBC_Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/web企业级应用架构";
        String user = "root";
        String password = "12345678";

        Connection connection;
        Statement mystatement;
        ResultSet resultSet;
        String sql = "select * from Weed5_Test";
        try {
            connection = DriverManager.getConnection(url, user, password);
            mystatement = connection.createStatement();
            resultSet = mystatement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID:" + resultSet.getInt("ID"));
                System.out.println("Name:" + resultSet.getString("Name"));
                System.out.println("Chinese:" + resultSet.getInt("Chinese"));
                System.out.println("Math:" + resultSet.getInt("Math"));
                System.out.println("English:" + resultSet.getInt("English"));
            }
            mystatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

