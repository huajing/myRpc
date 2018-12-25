package c.c.k.framework.client;

import c.c.k.framework.client.bio.ClientDelegate;

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
        /**
         * newProxyInstance
         * 第一个参数是接口的类加载器
         * 第二个参数是接口，如果不是接口类则会报错，也就是说被代理的对象必须是要通过接口实现
         * 第三个参数是接口调用的实现
         */
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用对象方法时返回
                return new ClientDelegate().callRemote(clazz, method, args);
            }
        });
    }
}
