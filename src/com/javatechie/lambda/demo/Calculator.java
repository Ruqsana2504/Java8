package com.javatechie.lambda.demo;

public interface Calculator {

//    void switchOn();

//    void sum(int input);

    int subtract(int num1, int num2);

}

class CalculatorImpl {

    public static void main(String[] args) {
//        Calculator calculator = () -> System.out.println("Switch On");
//        calculator.switchOn();

//        Calculator calculator = (input) -> System.out.println("Sum : " + input);
//        calculator.sum(5);

        Calculator calculator = (num1, num2) -> {
            if (num1 < num2)
                throw new RuntimeException("message");
            else
                return num1 - num2;
        };
        System.out.println(calculator.subtract(15, 10));
    }
}
