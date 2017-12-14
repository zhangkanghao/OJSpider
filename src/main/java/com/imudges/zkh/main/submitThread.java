package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class submitThread extends Thread {

    submitSpider submitSpider=new submitSpider();


    @Override
    public void run() {
        Connection connection= DBUtil.getConnection();
        try {
            //同一个statement多多个result set操作会引起result set 关闭错误
            Statement statement=connection.createStatement();
            String sql="SELECT * FROM proAns";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                submitSpider.submit("username","password",rs.getString("id"),rs.getString("answer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new submitThread()).run();
    }
}
