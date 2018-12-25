package c.c.k;

import c.c.k.impl.CalculatorProxy;

import java.io.Serializable;
import java.lang.reflect.Method;

public class ClientMain {



    public static void main(String[] args) {
//        本地调用
//        ICalculator calculator = new CalculatorLocalImpl();
//        System.out.println(calculator.add(1, 2));

        CalculatorProxy calculator = new CalculatorProxy();
        calculator.setClazz(ICalculator.class);
        int sum = calculator.add(1, 5);
        System.out.println(sum);
    }
}
