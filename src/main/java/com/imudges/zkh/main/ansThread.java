package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ansThread extends Thread{

    ansSpider ansSpider=new ansSpider();

    @Override
    public void run() {
        Connection connection= DBUtil.getConnection();
        try {

            //同一个statement多多个result set操作会引起result set 关闭错误
            Statement statement=connection.createStatement();
            String sql="SELECT p_id FROM proinfo";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                Statement statement1=connection.createStatement();
                ResultSet rs1=statement1.executeQuery("SELECT id FROM proAns WHERE id="+rs.getString("p_id"));
                if(!rs1.next())
                    ansSpider.getAnswer("username","password",rs.getString("p_id"));
                rs1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new ansThread()).run();
    }
}
