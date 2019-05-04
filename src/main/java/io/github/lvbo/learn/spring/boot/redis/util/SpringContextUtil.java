package io.github.lvbo.learn.spring.boot.redis.util;


import org.springframework.context.ApplicationContext;

/**
 * 得到SpringContext的工具类
 * @author lvbo
 */
public class SpringContextUtil {

    private static ApplicationContext applicationContext;

    /**
     * 获取上下文
     * @return 获取上下文
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 设置上下文
     * @param applicationContext 上下文信息
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 通过名字获取上下文中的bean
     * @param name bean名字
     * @return bean对象
     */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    /**
     * 通过类型获取上下文中的bean
     * @param requiredType bean类型
     * @return bean对象
     */
    public static Object getBean(Class<?> requiredType){
        return applicationContext.getBean(requiredType);
    }

}
