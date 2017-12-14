package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;
import com.imudges.zkh.model.proInfo;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class proInfoSpider{

    private OkHttpClient client=new OkHttpClient();


    //basicUrl到题目编号前一位为止
    public void getProblem(String basicUrl) throws IOException, SQLException {

        /**
         * html的字符串
         */
        String resultStr="";


        for (int i=1000;i<2000;i++) {
            /**
             * 请求信息，获取连接
             */
            proInfo proIns=new proInfo();
            String finalUrl=basicUrl;
            finalUrl+=String.valueOf(i);
            Request request=new Request.Builder()
                    .url(finalUrl)
                    .build();
            Response response=client.newCall(request).execute();
            if(!response.isSuccessful()){
                System.out.println("第"+i+"题抓取失败");
                continue;
            }


            /**
             * 获取信息
             */
            resultStr=response.body().string();
            if(resultStr.contains("题目不可用")||resultStr.contains("This problem is in Contest(s) below:")){
                System.out.println("第"+i+"题抓取失败");
                continue;
            }
            //正则获取时间限制，内存限制，提交数和解决数
            regexGet regex=new regexGet(resultStr);
            ArrayList<String> resultList=regex.run();


            /**
             * parse Info, .get()是获取所得元素的字符串  .trim()去掉首尾空格
             * 声明proInfo模型，保存信息
             */
            Document document= Jsoup.parse(resultStr);
            proIns.setId(String.valueOf(i));
            proIns.setName(Xsoup.select(document,"/html/body//title/text()").get().trim());
            try {
                if(proIns.getName()==""||proIns.getName()==null)
                    proIns.setName(Xsoup.select(document,"/html/body//title/p/text()").get().trim());
            } catch (Exception e) {
                continue;
            }
            proIns.setTimeLimit(resultList.get(0));
            proIns.setMemoryLimit(resultList.get(1));
            proIns.setSubmit(resultList.get(2).substring(0,resultList.get(2).length()-1));
            proIns.setSolved(resultList.get(3).substring(0,resultList.get(3).length()-1));
            proIns.setDescription(Xsoup.select(document,"//div[@class='jumbotron']/div[1]/text()").get().trim());
            System.out.println("第"+i+"题已抓取");


            //持久化
            Connection connection= DBUtil.getConnection();
            try {
                PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO proInfo VALUES (?,?,?,?,?,?,?)");
                preparedStatement.setString(1,proIns.getId());
                preparedStatement.setString(2,proIns.getName());
                preparedStatement.setString(3,proIns.getTimeLimit());
                preparedStatement.setString(4,proIns.getMemoryLimit());
                preparedStatement.setString(5,proIns.getSubmit());
                preparedStatement.setString(6,proIns.getSolved());
                preparedStatement.setString(7,proIns.getDescription());
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("真是fuck了陈丰");
                continue;
            }

        }
    }
}
