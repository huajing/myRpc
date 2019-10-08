package c.c.k;

import c.c.k.ICalculator;
import c.c.k.framework.proxy.ProxyCglib;
import c.c.k.framework.proxy.ProxyDynamic;
import c.c.k.impl.CalculatorLocalImpl;
import c.c.k.impl.CalculatorProxyStatic;
import org.junit.Test;

/**
 *
 * @Title c.c.k.client.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ClientTest {
    /**
     * 本地调用
     */
    @Test
    public void testLocalProxy(){
        ICalculator calculator = new CalculatorLocalImpl();
        System.out.println(calculator.add(1, 2));
    }

    /**
     * 静态代理
     */
    @Test
    public void testStatic(){
        CalculatorProxyStatic calculator = new CalculatorProxyStatic();
        calculator.setClazz(ICalculator.class);
        int sum = calculator.add(1, 5);
        System.out.println(sum);
    }

    /**
     *  动态代理
     */
    @Test
    public void testDynamic(){
        ICalculator calculator = (ICalculator) ProxyDynamic.getProxyInstance(ICalculator.class);
        System.out.println(calculator.getClass());
        int sum = calculator.add(1, 5);
        System.out.println(sum);
    }

    /**
     * cglib代理
     */
    @Test
    public void testCglic(){
        ICalculator calculator = (ICalculator) ProxyCglib.getProxyInstance(ICalculator.class);
        System.out.println(calculator.getClass());
        System.out.println(calculator.add(1,2));
    }
}
