package c.c.k;

public class Main {
    public static void main(String[] args) {
        ICalculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(1, 2));
    }
}
