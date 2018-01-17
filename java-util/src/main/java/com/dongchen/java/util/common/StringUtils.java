package com.dongchen.java.util.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: mdd
 * @date:2017/12/12
 */
public class StringUtils {

    /**
     * 将输入流转化为字符串
     *
     * @param
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 获取uuid
     *
     * @param
     * @return
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString();

    }
}
