package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        List<Integer> start = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        count = scanner.nextInt();
        System.out.println("Введите элементы списка: ");
        for (int i = 0; i < count; i++) {
            int a = scanner.nextInt();
            start.add(a);
        }
        System.out.println("Ваш список без дупликатов: ");
        List<Integer> result = RemoveDuplicates.removeDuplicates(start);
        for (int b : result){
            System.out.print(b + " ");
        }
    }
}