package Polymorphism;

import Inheritance.Animal;

public class CalTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(10,20);
        System.out.println(result);
    }
}
