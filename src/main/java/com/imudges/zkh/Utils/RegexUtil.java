package com.imudges.zkh.Utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static ArrayList<String> run(String regexStr, String matchStr){
        Pattern pattern=Pattern.compile(regexStr);
        Matcher matcher=pattern.matcher(matchStr);
        ArrayList<String> resultList=new ArrayList<String>();
        while(matcher.find()){
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public static void main(String[] args) {
        String matchStr= "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"\">\n" +
                "    <link rel=\"icon\" href=\"../../favicon.ico\">\n" +
                "\n" +
                "    <title>IMUDGES OJ</title>\n" +
                "    \n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/katex.min.css\">\n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/mathjax.css\">\n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/semantic.min.css\">\n" +
                "\n" +
                "<!-- 新 Bootstrap 核心 CSS 文件 -->\n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/bootstrap.min.css\">\n" +
                "\n" +
                "<!-- 可选的Bootstrap主题文件（一般不用引入） -->\n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/bootstrap-theme.min.css\">\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"template/bs3/imuoj.css\">\n" +
                "    <style>\n" +
                "        h2{\n" +
                "            color: royalblue;\n" +
                "        }\n" +
                "        .content{\n" +
                "            font-size: 1.5em;\n" +
                "        }\n" +
                "        .sampledata{\n" +
                "            background-color: #8DB8FF;\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n" +
                "    <!--[if lt IE 9]>\n" +
                "    <script src=\"http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js\"></script>\n" +
                "    <script src=\"http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js\"></script>\n" +
                "    <![endif]-->\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <!-- Static navbar -->\n" +
                "<nav class=\"navbar navbar-default navbar-fixed-top\" role=\"navigation\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"navbar-header\">\n" +
                "            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\"\n" +
                "                    aria-expanded=\"false\" aria-controls=\"navbar\">\n" +
                "                <span class=\"sr-only\">Toggle navigation</span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "                <span class=\"icon-bar\"></span>\n" +
                "            </button>\n" +
                "            <a class=\"navbar-brand\" href=\"./\">IMUDGES OJ</a>\n" +
                "        </div>\n" +
                "        <div id=\"navbar\" class=\"navbar-collapse collapse\">\n" +
                "            <ul class=\"nav navbar-nav nav-pills\">\n" +
                "                <li class=\"\">\n" +
                "                    <a href=\"bbs.php\">论坛</a>\n" +
                "                </li>\n" +
                "                <li class=\"hidden-md \">\n" +
                "                    <a href=\"faqs.php\">FAQ</a>\n" +
                "                </li>\n" +
                "                <li class=\"\">\n" +
                "                    <a href=\"problemset.php\">问题</a>\n" +
                "                </li>\n" +
                "                                    <li class=\"hidden-md \">\n" +
                "                        <a href=\"category.php\">来源/分类</a>\n" +
                "                    </li>\n" +
                "                                    <li class=\"\">\n" +
                "                    <a href=\"status.php\">状态</a>\n" +
                "                </li>\n" +
                "                <li class=\"\">\n" +
                "                    <a href=\"ranklist.php\">排名</a>\n" +
                "                </li>\n" +
                "                <li class=\"\">\n" +
                "                    <a href=\"contest.php\">竞赛&作业<span class='badge'>2</span></a>\n" +
                "                </li>\n" +
                "                                            </ul>\n" +
                "            <ul class=\"nav navbar-nav navbar-right\">\n" +
                "                <li class=\"dropdown\">\n" +
                "                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><span id=\"profile\">Login</span><span\n" +
                "                                class=\"caret\"></span></a>\n" +
                "                    <ul class=\"dropdown-menu\" role=\"menu\">\n" +
                "                        <script src=\"template/bs3/profile.php?1737386478\"></script>\n" +
                "                        <!--<li><a href=\"../navbar-fixed-top/\">Fixed top</a></li>-->\n" +
                "                    </ul>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </div><!--/.nav-collapse -->\n" +
                "    </div><!--/.container-fluid -->\n" +
                "</nav>\n" +
                "\n" +
                "\n" +
                "    <!-- Main component for a primary marketing message or call to action -->\n" +
                "    <div class=\"jumbotron\">\n" +
                "\n" +
                "        <title>问题 1001 --A+B Problem with sample answers</title><center><h3>1001: A+B Problem with sample answers</h3><span class=green>时间限制: </span>10 Sec&nbsp;&nbsp;<span class=green>内存限制: </span>125 MB<br><span class=green>提交: </span>161&nbsp;&nbsp;<span class=green>解决: </span>128<br><br><div class=\"btn-group \" role=\"group\" ><a type='button' class='btn btn-primary' href='submitpage.php?id=1001'>提交</a><a type=\"button\" class='btn btn-default' href='problemstatus.php?id=1001'>状态</a><a type='button' class='btn btn-default' href='bbs.php?pid=1001'>论坛</a></div></center><h2>题目描述</h2><div class=content><p>Calculate a+b</p></div><h2>输入</h2><div class=content><p>Two integer a,b (0&lt;=a,b&lt;=10)</p></div><h2>输出</h2><div class=content><p>Output a+b</p></div><h2>样例输入</h2>\n" +
                "<pre class=content><span class=sampledata>1 2</span></pre><h2>样例输出</h2>\n" +
                "<pre class=content><span class=sampledata>3</span></pre><h2>提示</h2>\n" +
                "<div class=content><p><p></p>\n" +
                "<p>#include &lt;stdio.h&gt;</p>\n" +
                "<p></p>\n" +
                "<p>int main()</p>\n" +
                "<p></p>\n" +
                "<p>{</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; int a,b;</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; while(scanf(&quot;%d %d&quot;,&amp;a, &amp;b) != EOF)</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; printf(&quot;%d\\n&quot;,a+b);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; return 0;</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>#include &lt;iostream&gt;</p>\n" +
                "<p></p>\n" +
                "<p>using namespace std;</p>\n" +
                "<p></p>\n" +
                "<p>int main()</p>\n" +
                "<p></p>\n" +
                "<p>{</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; int a,b;</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; while(cin &gt;&gt; a &gt;&gt; b)</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; cout &lt;&lt; a+b &lt;&lt; endl;</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>program p1001(Input,Output);</p>\n" +
                "<p></p>\n" +
                "<p>var</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp; a,b:Integer;</p>\n" +
                "<p></p>\n" +
                "<p>begin</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; while not eof(Input) do</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp; begin</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Readln(a,b);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Writeln(a+b);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp; end;</p>\n" +
                "<p></p>\n" +
                "<p>end.</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>import java.util.Scanner;</p>\n" +
                "<p></p>\n" +
                "<p>public class Main {</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;public static void main(String[] args) {</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;Scanner in = new Scanner(System.in);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;while (in.hasNextInt()) {</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;int a = in.nextInt();</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;int b = in.nextInt();</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;System.out.println(a + b);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;}</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;}</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>a=gets.chomp</p>\n" +
                "<p></p>\n" +
                "<p>b=&quot;0&quot;</p>\n" +
                "<p></p>\n" +
                "<p>a.each_line(&quot; &quot;){</p>\n" +
                "<p></p>\n" +
                "<p>|d|</p>\n" +
                "<p></p>\n" +
                "<p>b=b+&quot;+&quot;+d</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p></p>\n" +
                "<p>puts eval(b)</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>read a b</p>\n" +
                "<p></p>\n" +
                "<p>echo $(($a+$b))</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>import sys</p>\n" +
                "<p></p>\n" +
                "<p>for line in sys.stdin:</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; a = line.split()</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; print int(a[0]) + int(a[1])</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>&lt;?php</p>\n" +
                "<p></p>\n" +
                "<p>while (fscanf(STDIN, &quot;%d%d&quot;, $a, $b) == 2) {</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; print ($a + $b) . &quot;\\n&quot;;</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p></p>\n" +
                "<p>?&gt;</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>#! /usr/bin/perl -w</p>\n" +
                "<p></p>\n" +
                "<p>while(&lt;&gt;){</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp; chomp;</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp; ($a,$b)=split(/\\s/,$_);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp; printf &quot;%d\\n&quot;,$a+$b;</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p><br />\n" +
                "<br />\n" +
                "</p>\n" +
                "<p>using System;</p>\n" +
                "<p></p>\n" +
                "<p>public class Sum</p>\n" +
                "<p></p>\n" +
                "<p>{</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; public static void Main()</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; {</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; //string token = Console.ReadLine();</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; //int test = int.Parse(token);</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(int k = 0; k &lt; 1;k++){</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; string[] tokens = Console.ReadLine().Split(' ');</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; Console.WriteLine(int.Parse(tokens[0]) + int.Parse(tokens[1]));</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp; &nbsp;}</p>\n" +
                "<p></p>\n" +
                "<p>&nbsp;&nbsp;&nbsp; }</p>\n" +
                "<p></p>\n" +
                "<p>}</p>\n" +
                "<p></p></p></div><center><div class=\"btn-group\" role=\"group\" ><a type='button' class='btn btn-primary' href='submitpage.php?id=1001'>提交</a><a type=\"button\" class='btn btn-default' href='problemstatus.php?id=1001'>状态</a></div></center>    </div>\n" +
                "</div> <!-- /container -->\n" +
                "\n" +
                "\n" +
                "<!-- Bootstrap core JavaScript\n" +
                "================================================== -->\n" +
                "<!-- Placed at the end of the document so the pages load faster -->\n" +
                "<script src=\"template/bs3/jquery.min.js\"></script>\n" +
                "\n" +
                "<script src=\"template/bs3/bootstrap.min.js\"></script>\n" +
                "\n" +
                "<script>\n" +
                "\n" +
                "    $(document).ready(function () {\n" +
                "        var msg = \"<marquee style='margin-top:10px' id=broadcast scrollamount=1 scrolldelay=50 onMouseOver='this.stop()' onMouseOut='this.start()' class=toprow>\"+\"\\u65e5\\u5e38\\u7ef4\\u62a4:cf QQ:765324662 \\u90ae\\u7bb1:chenfeng@imudges.com\"+\n" +
                "        \"</marquee>\";\n" +
                "        $(\".jumbotron\").prepend(msg);\n" +
                "        $(\"form\").append(\"<div id='csrf' />\");\n" +
                "        $(\"#csrf\").load(\"csrf.php\");\n" +
                "        $(\"body\").append(\"<div id=footer align=center >All Copyright Reserved 2017 <a href='http://www.imudges.com' target='_blank'>IMUDGES</a><br/>GPLv2 licensed by <a href='https://github.com/zhblue/hustoj' >HUSTOJ</a> \" + (new Date()).getFullYear() + \"<br/><br/></div>\");\n" +
                "        // $(\"body\").append(\"<div class=center ><a href='https://www.duba.com/?un_454974_116387' title='每天点击一次开发者可获得￥0.06' target='_blank'>捐助系统开发者</a></div>\");\n" +
                "    });\n" +
                "    // console.log(\"If you want to change the appearance of the web pages, make a copy of bs3 under template directory.\\nRename it to whatever you like, and change the $OJ_TEMPLATE value in db_info.inc.php\\nAfter that modify files under your own directory .\\n\");\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "<script>\n" +
                "    function phpfm(pid) {\n" +
                "        //alert(pid);\n" +
                "        $.post(\"admin/phpfm.php\", {'frame': 3, 'pid': pid, 'pass': ''}, function (data, status) {\n" +
                "            if (status == \"success\") {\n" +
                "                document.location.href = \"admin/phpfm.php?frame=3&pid=\" + pid;\n" +
                "            }\n" +
                "        });\n" +
                "    }\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>\n" +
                "<!--not cached-->\n" +
                "\n";
        String regexStr="</span>([\\d].*?[cB&<])";
        ArrayList<String> resultList=RegexUtil.run(regexStr,matchStr);
        for(int i=0;i<resultList.size();i++)
            System.out.println(resultList.get(i));
    }

}
