package com.imudges.zkh.main;

import com.imudges.zkh.Utils.DBUtil;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ansSpider {

    OkHttpClient client=new OkHttpClient();

    public String adjustAns(String ans){
        int last=0,num;
        for (int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='}')last=i;
        }
        String tmp=ans.substring(0,last+1);
        tmp=tmp.replaceAll("&gt;",">");
        tmp=tmp.replaceAll("&lt;","<");
        tmp=tmp.replaceAll("&quot;","\"");
        tmp=tmp.replaceAll("&amp;","&");
        tmp=tmp.replaceAll("&#039;","'");
        tmp=tmp.replaceAll("#include","\n#include");
        tmp=tmp.replaceAll("using namespace std;","\nusing namespace std;\n");
        return tmp;
    }

    public void getAnswer(String username,String password,String Id) throws IOException, SQLException {

        /**
         *  密码md5加密
         */
        md5Code encrypt=new md5Code();
        String password_encrypt=encrypt.GetMD5Code(password);

        /**
         * login
         */
        //login data
        FormBody formBody=new FormBody.Builder()
                .add("user_id",username)
                .add("password",password_encrypt)
                .build();
        //login request
        Request request=new Request.Builder()
                .url("http://106.15.228.191/login.php")
                .post(formBody)
                .build();
        //login
        Response response=client.newCall(request).execute();
        if(!response.isSuccessful()) {
            System.out.println("登录请求失败");return;
        }
        if(response.body().string().contains("UserName or Password Wrong!")){
            System.out.println("用户名或密码错误");return;
        }
        String cookie=response.header("set-cookie");

//        System.out.println(username+"登录成功");


        /**
         * 得到正确运行id
         */
        request=new Request.Builder()
                .url("http://106.15.228.191/status.php?problem_id="+Id+"&user_id=&language=1&jresult=4")
                .addHeader("cookie",cookie)
                .build();
        response=client.newCall(request).execute();
        if(!response.isSuccessful()) {
            System.out.println("运行ID请求失败");return;
        }
        Document document= Jsoup.parse(response.body().string());
        String runId= null;
        try {
            runId = Xsoup.select(document,"//div[@class='jumbotron']/div[@class='table-responsive]/table/tbody/tr[1]/td[1]/text()").get().trim();
        } catch (Exception e) {
            System.out.println(Id+"没有C++正确答案");
            return;
        }

        /**
         * 请求答案
         */
       request=new Request.Builder()
                .url("http://106.15.228.191/showsource.php?id="+runId)
                .header("cookie",cookie)
                .build();

        response=client.newCall(request).execute();
        if(!response.isSuccessful()) {
            System.out.println("答案页面请求失败");return;
        }
        document=Jsoup.parse(response.body().string());
        String ans=Xsoup.select(document,"//div[@class='jumbotron']/pre/text()").get();
        //adjustans
        ans=adjustAns(ans);
//        save answer
        Connection connection= DBUtil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO proAns VALUES (?,?)");
        preparedStatement.setString(1,Id);
        preparedStatement.setString(2,ans);
        preparedStatement.execute();
        preparedStatement.close();
        System.out.println("ID:"+Id+"成功");
    }

    public static void main(String[] args) {
        ansSpider ansSpider=new ansSpider();
        /*try {
            ansSpider.getAnswer("BalalaTheFairy","zzz123","1050");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        System.out.println(ansSpider.adjustAns("#include<iostream> #include<iomanip> using namespace std; int main() }"));
    }
}
