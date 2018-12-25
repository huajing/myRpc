package c.c.k.framework.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @Title c.c.k.framework.client
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ProxyDynamic {
    /**
     * 获取被代理对象
     * com.sun.proxy.$Proxy0
     * @param clazz
     * @return
     */
    public static final Object getProxyInstance(final Class clazz){
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用对象方法时返回
                return new ClientDelegate().callRemote(clazz, method, args);
            }
        });
    }
}
