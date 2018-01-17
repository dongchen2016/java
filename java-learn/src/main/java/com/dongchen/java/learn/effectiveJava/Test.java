package com.dongchen.java.learn.effectiveJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class Test {
    public static void test(){
        List<String> list = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.length()-o2.length();
                return i;
            }
        });
    }

}
