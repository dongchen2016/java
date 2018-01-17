package com.dongchen.java.learn.runoobcom.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class Input {

    /**
     * 读取文件内容
     * 以字符串的形式返回
     * @param
     * @return
     */
    public static String readFile(String filePath){
        String result="";
        try {
            FileInputStream fip = new FileInputStream(filePath);
            // 构建FileInputStream对象

            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            // 构建InputStreamReader对象,编码与写入相同

            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char) reader.read());
                // 转成char加到StringBuffer对象中
            }
            result = sb.toString();
            System.out.println(result);
            reader.close();
            // 关闭读取流

            fip.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        // 关闭输入流,释放系统资源
        return result;
    }
}
