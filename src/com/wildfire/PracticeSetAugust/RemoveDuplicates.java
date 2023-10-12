package com.wildfire.PracticeSetAugust;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {10, 10, 50, 30, 40, 70, 60, 90, 100, 110, 110, 30};
        removeDuplicates(arr);
    }

    private static void removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(set.add(arr[i])) {
                System.out.println("added element " + arr[i]);
            }
            else{
                System.out.println("not added as Duplicate value of - " + arr[i] + " already present");
            }
        }
    }
}
