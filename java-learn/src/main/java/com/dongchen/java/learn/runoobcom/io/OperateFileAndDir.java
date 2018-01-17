package com.dongchen.java.learn.runoobcom.io;

import java.io.File;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class OperateFileAndDir {

    /**
     * 创建目录
     * 方法有两个：
     * mkdir(),成功返回ture，失败返回false。失败表明指定的路径已经存在或者是整个路径还不存在
     * mkdirs(),创建一个文件夹和他的父文件夹。
     * @param
     * @return
     */
    public static void createDir(String path){
        File dir = new File(path);

        //创建目录
        dir.mkdir();
        dir.mkdirs();
    }

    /**
     * 一个目录也是一个File对象
     * 读取某个目录下面
     * 包含的文件及文件夹
     * @param
     * @return
     */
    public static void readDir(String dirName){
        File file = new File(dirName);
        if (file.isDirectory()){
            System.out.println("目录 " + dirName);
            String s[] = file.list();
            for (int i=0; i < s.length; i++) {
                File f = new File(dirName + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        }else {
            System.out.println(dirName+ "不是一个目录");
        }
    }

    /**
     * 删除目录或者是文件
     * @param name 目录名或文件名
     * @return
     */
    public static void deleteFileOrDir(String name){
        File folder = new File(name);
        File[] files = folder.listFiles();
        if(files!=null) {
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFileOrDir(f.getName());
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }


    public static void main(String[] args){
        readDir("C:\\Users\\mdd\\Desktop\\script");
    }
}
