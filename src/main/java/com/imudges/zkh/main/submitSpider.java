package com.imudges.zkh.main;

import okhttp3.*;
import org.jsoup.select.Evaluator;

import java.io.IOException;

public class submitSpider {
    OkHttpClient client=new OkHttpClient();

    public void submit(String username,String password,String proId,String code) throws IOException {
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


        //csrf request info                 http://106.15.228.191/csrf.php



        //submit request
        FormBody formBody1=new FormBody.Builder()
                .add("language","1")
                .add("source",code)
                .add("id", proId)
                .build();

        request=new Request.Builder()
                .url("http://106.15.228.191/submit.php")
                .header("cookie",cookie)
                .post(formBody1)
                .build();

        response=client.newCall(request).execute();

        if(!response.isSuccessful()){
            System.out.println(proId+"上传失败");return;}
        System.out.println(proId+"上传成功");


    }


    public static void main(String[] args) {
        String code="#include<iostream>\n" +
                "using namespace std;\n" +
                " int main() { int a,b; cin>>a>>b; cout<<a+b<<endl; }";
        submitSpider submitSpider=new submitSpider();
        try {
            submitSpider.submit("username","password","1001",code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
