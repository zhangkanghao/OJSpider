package com.imudges.zkh.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

    private static Connection connection=DBUtil.getConnection();
    public static void run() throws SQLException {
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("SELECT * FROM proAns");
        while(rs.next()){
            System.out.println("ID:"+rs.getString("id"));
            System.out.println("CODE:\n"+rs.getString("answer"));
        }
        rs.close();
        statement.close();
    }
    public static void main(String[] args) {
        try {
            run();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
