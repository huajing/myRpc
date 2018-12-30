package c.c.k.impl;

import c.c.k.ICalculator;

/**
 * 本地实现
 */
public class CalculatorLocalImpl implements ICalculator {
    public int add(int a, int b) {
        return a + b;
    }
}
