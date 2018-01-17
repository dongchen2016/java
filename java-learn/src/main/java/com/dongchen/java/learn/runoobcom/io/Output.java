package com.dongchen.java.learn.runoobcom.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class Output {
    public static final String txt = Input.readFile("C:\\Users\\mdd\\Desktop\\test\\输入.txt");

    /**
     * 输出字符串
     * 输出内容到某个文件
     * 如果文件不存在则创建文件
     * @param
     * @return
     */
    public static void outputFile(String outPath) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(outPath);
            //调用Write 方法写入数据
            fw.write("123");
            //进行刷新，将数据直接写入到目的地中
            fw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
