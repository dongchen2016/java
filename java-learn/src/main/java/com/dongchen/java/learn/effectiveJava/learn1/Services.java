package com.dongchen.java.learn.effectiveJava.learn1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: mdd
 * @date:2017/12/16
 */
public class Services {

    private Services(){};

    private static final Map<String,Provider> providers =
            new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<dev>";

    public static void registerDefaultProvider(Provider provider){
        registerProvider(DEFAULT_PROVIDER_NAME,provider);
    }

    public static void registerProvider(String name,Provider provider){
        providers.put(name,provider);
    }

    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if (null ==p){
            System.out.println("No Provider registered with name:" + name);
            return null;
        }else {
            return p.newService();
        }
    }
}
