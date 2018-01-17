package com.dongchen.java.util.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: mdd
 * @date:2017/12/5
 */
public class StringUtil {

    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }

        return str;
    }


    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|/n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static void main(String[] args){
        System.out.println(addZeroForNum("123",10));
    }
}
