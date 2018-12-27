package c.c.k.impl;

import c.c.k.framework.client.ClientBIO;

import java.lang.reflect.Method;

/**
 * 静态代理实现本地调用
 * @Title c.c.k.impl
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class CalculatorProxyStatic {
    private Class clazz;

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public int add(int a, int b){
        Object object = null;
        try {
            Method method = clazz.getMethod("add", new Class[]{int.class, int.class});
            object = new ClientBIO().callRemote(clazz, method, new Object[]{a, b});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if(object == null)
            return 0;
        return (Integer) object;
    }
}
