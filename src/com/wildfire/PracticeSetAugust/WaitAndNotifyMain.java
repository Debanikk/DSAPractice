package com.wildfire.PracticeSetAugust;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaitAndNotifyMain {
    public static void main(String[] args) {
        System.out.println("Enter integer value till which you want to print as 1...n -");
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        List<Integer> queue = new ArrayList<>();

        Thread t1 = new Thread(new EvenProducer(val, queue));
        Thread t2 = new Thread(new OddProducer(val, queue));
        t1.start();
        t2.start();

        System.out.println("Return to main thread");

        try{
            t1.join();
            t2.join();
            System.out.println("Thread enters main again");
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
