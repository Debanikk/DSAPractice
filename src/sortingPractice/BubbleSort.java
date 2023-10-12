package sortingPractice;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        printArray(arr);
        //sortArray(arr, arr.length);

        System.out.println("Now lets try this game!!!!");
        System.out.println("The next program will print the number of rotations in the array after M number of rotations, M will be provided by user");
        System.out.println("Please enter number you want the array for rotation - ");
        Scanner scanner = new Scanner(System.in);
        int rotationCount = scanner.nextInt();
        int totalSwaps = totalBubbleSortSwaps(arr, rotationCount);
        if(totalSwaps > 0 && arr.length > 1) {
            System.out.println(String.format("The number of swaps made for rotation - %s is - %s", rotationCount, totalSwaps));
        }
        else{
            System.out.println("The array is already sorted");
        }
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        System.out.println("Bubble Sort Process Starts Here!!!!!");
        for(int i = 0; i < arr.length; i++) {
            System.out.println(String.format("The value of array at position [%s] is - %s", i, arr[i]));
        }
    }

    private static void sortArray(int[] arr, int len) {
        for(int i = 0; i < len; i++) {
            int swap = 0;
            for(int j = 1; j < len-i; j++) {
                if(arr[j-1] > arr[j]) {
                    swapIntVal(j, arr);
                    /*int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;*/
                    swap = 1;
                }
            }
            if(swap == 0){
                break;
            }
        }
        System.out.println("After sort printing array value");
        for(int i = 0; i < arr.length; i++) {
            System.out.println(String.format("The value of array at position [%s] is - %s", i, arr[i]));
        }
    }

    private static void swapIntVal(int a, int[] arr ) {
        int temp = arr[a-1];
        arr[a-1] = arr[a];
        arr[a] = temp;
    }

    private static int totalBubbleSortSwaps(int[] arr, int mRot) {
        int len = arr.length;
        int counter = 0;

        if(arr == null || arr.length < 1) {
            return counter;
        }

        if(mRot > len) {
            mRot = len;
        }

        for(int i = 0; i < mRot; i++) {
            for(int j = 1; j < len - i; j++) {
                if(arr[j-1] > arr[j]) {
                    swapIntVal(j, arr);
                    counter++;
                }
            }
        }
        return counter;
    }
}
