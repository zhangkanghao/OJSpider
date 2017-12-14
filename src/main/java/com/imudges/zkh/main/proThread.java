package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class proThread extends Thread {

    proInfoSpider proSpider=new proInfoSpider();

    @Override
    public void run() {
        try {
            proSpider.getProblem("http://106.15.228.191/problem.php?id=");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Thread(new proThread()).run();

    }
}
