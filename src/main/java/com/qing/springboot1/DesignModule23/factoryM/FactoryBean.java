package com.qing.springboot1.DesignModule23.factoryM;

public class FactoryBean {
    // 必须要求你这个类有 无参构造器
    public static Factory getBean(String className){
        if(className != null && !"".equals(className)){
            Class<?> aClass = null;
            try {
                aClass = Class.forName(className);
                Object ob = aClass.newInstance();
                if(ob instanceof Factory){
                    return (Factory) ob;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
