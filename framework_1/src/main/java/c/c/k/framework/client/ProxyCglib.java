package c.c.k.framework.client;

import c.c.k.framework.client.bio.ClientDelegate;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理，被代理的对象可以不通过接口实现
 * @Title c.c.k.framework.client
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ProxyCglib {
    public static final Object getProxyInstance(final Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodInterceptor(){
            /**
             * 实现与jdk中的动态代理类似，给用户自己实现调用逻辑
             * @param o 代理对象c.c.k.ICalculator$$EnhancerByCGLIB$$19178248
             * @param method 方法
             * @param objects 参数
             * @param methodProxy 代理方法 net.sf.cglib.proxy.MethodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("before invoke...");
//                System.out.println(o.getClass());
                System.out.println(methodProxy.getClass());
                Object obj = ClientDelegate.callRemote(clazz, method, objects);
//                System.out.println("after invoke...");
                return obj;
            }
        });
        return enhancer.create();
    }
}
