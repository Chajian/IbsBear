package com.bear.util;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 翻译
 */
public class Translate {

    /**
     * 获取真实的消息
     * @param string 消息源码
     * @return 转换成真正的消息
     */
    public static String getRealMessage(String string){
        Pattern pattern = Pattern.compile(StringRule.TRANSLATEMESSAGE.rule);
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
        return matcher.replaceAll("");
        else {
            Pattern pattern1 = Pattern.compile(StringRule.TRANSLATEMESSAGETWO.rule);
            Matcher matcher1 = pattern1.matcher(string);
            if(matcher1.find()) {
                String message = matcher1.group().replace("\"", "");
                return message;
            }
        }
        return "";
    }

    /**
     * 检查target中是否出现关键字key
     * @param target 被检查对象
     * @param key 关键字
     * @return
     */
    public static boolean hasString(String target,String key){
        Pattern pattern = Pattern.compile(StringRule.SEARCHKEY.replaceKey(key));
        Matcher matcher = pattern.matcher(target);

        return  matcher.find();
    }

    public static String getItemByid(int id){
        return null;
    }

    public static String getBackByid(int id){
        return "";
    }

    public static String getBackItemByid(int backid,int position){
        return "";
    }

    public static String getUserByaccount(long account){
        return "";
    }


}
