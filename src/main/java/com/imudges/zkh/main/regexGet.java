package com.imudges.zkh.main;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexGet {

    private String htmlStr;
    regexGet(){}
    regexGet(String htmlStr){this.htmlStr=htmlStr;}


    //get timelimit,Memorylimie,submit,solved
    public ArrayList<String> run(){
        String TLregex="</span>([\\d].*?[cB&<])";
        Pattern pattern=Pattern.compile(TLregex);
        Matcher matcher=pattern.matcher(htmlStr);
        ArrayList<String> resultList=new ArrayList<String>();
        while(matcher.find()){
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

}
