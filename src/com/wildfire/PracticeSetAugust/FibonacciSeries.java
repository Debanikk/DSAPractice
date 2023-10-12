package com.wildfire.PracticeSetAugust;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("Please enter a number as index for fibonacci series print ");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        int result = fibonacci(val);
        System.out.println(String.format("for provided index - %s, fibonacci number is - %s",val, result));
    }

    private static int fibonacci(int n) {
        int[] fib = new int[n + 2];
        int i;
        fib[0] = 0;
        fib[1] = 1;
        for(i = 2; i < n + 2; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n-1];
    }
}
