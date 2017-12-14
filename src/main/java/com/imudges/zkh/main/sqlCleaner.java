package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlCleaner {
    Connection connection= DBUtil.getConnection();

    public void sqlClean(){
        try {
            Statement statement=connection.createStatement();
            String clean="DELETE FROM proinfo WHERE p_solved=0";
            statement.executeUpdate(clean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
