package c.c.k;

import c.c.k.framework.client.ClientDelegate;
import c.c.k.framework.client.ProxyCglib;
import c.c.k.framework.client.ProxyDynamic;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ClientMain {
    public static void main(String[] args) {
//        本地调用
//        ICalculator calculator = new CalculatorLocalImpl();
//        System.out.println(calculator.add(1, 2));
//        System.out.println(sum);

//        静态代理
//        CalculatorProxyStatic calculator = new CalculatorProxyStatic();
//        calculator.setClazz(ICalculator.class);
//        int sum = calculator.add(1, 5);
//        System.out.println(sum);

//        动态代理
//        ICalculator calculator = (ICalculator) ProxyDynamic.getProxyInstance(ICalculator.class);
//        System.out.println(calculator.getClass());
//        int sum = calculator.add(1, 5);
//        System.out.println(sum);

        ICalculator calculator = (ICalculator) ProxyCglib.getProxyInstance(ICalculator.class);
        System.out.println(calculator.getClass());
        System.out.println(calculator.add(1,2));
    }

    class Abc{
        public int add(int a){
            return a + 1;
        }
    }
}
