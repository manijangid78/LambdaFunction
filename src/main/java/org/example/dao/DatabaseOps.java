package org.example.dao;

import org.example.models.User;

import java.sql.*;

public class DatabaseOps {

    static void addUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbName = "test";
            String userName = "admin";
            String password = "";
            String hostname = "";
            String port = "3306";
            //String url = System.getProperty("ae-cloudsql.cloudsql-database-url");
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;

            conn = DriverManager.getConnection(url);
            String statement = "INSERT INTO `test`.`User` (`Name`, `Email`, `Age`, `RollNo`, `Designation`) VALUES (?, ?, ?, ?, ?);";
            stmt = conn.prepareStatement(statement);
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setInt(3,user.getAge());
            stmt.setString(4,user.getRollNo());
            stmt.setString(5,user.getDesignation());
            return stmt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

}
