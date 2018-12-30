package c.c.k;

import javax.swing.*;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(ICalculator.class.getSimpleName());

        System.out.println(Method.class instanceof Serializable);
    }
}
