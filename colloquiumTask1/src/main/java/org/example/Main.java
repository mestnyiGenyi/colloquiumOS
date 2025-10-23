package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        calculator.validateInput(n);
        List<BigInteger> result = calculator.calculateFactorials(n);
        System.out.println("Список факториалов от 1 до n:");
        for (BigInteger bint : result){
            System.out.print(bint + " ");
        }
    }
}