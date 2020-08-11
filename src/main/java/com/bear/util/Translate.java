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
    public String getRealMessage(String string){
        Pattern pattern = Pattern.compile(StringRule.SEARCHKEY.replaceKey(""));
        Matcher matcher = pattern.matcher(string);
        return matcher.replaceAll("");
    }

}
