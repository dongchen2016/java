package com.dongchen.java.learn.runoobcom;

import com.dongchen.java.learn.runoobcom.io.Output;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class StreamFileAndIO {

    public static void main(String[] args){
        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\mdd\\Desktop\\test\\输入.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            while (inputStreamReader.ready()){
                stringBuffer.append((char) inputStreamReader.read());
            }
            System.out.println(stringBuffer.toString());
            inputStreamReader.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Output.outputFile("C:\\Users\\mdd\\Desktop\\test\\test.txt");
    }
}
