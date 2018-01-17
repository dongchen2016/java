package com.dongchen.java.http.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: mdd
 * @date:2017/12/1
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------------");

        System.out.println("---------------me.shijunjie.util.SpringUtil------------------------------------------------------");

        System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil.applicationContext+"========");

        System.out.println("---------------------------------------------------------------------");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过bean的name获取bean,然后将Object转化为对应的对象
     * @param
     * @return
     */
    public  Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

}
