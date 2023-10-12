package sortingPractice;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        System.out.println("Value of array before sort is - ");
        printArray(arr);
        System.out.println("Value of array after sort is - ");
        int[] result = sortArray(arr);
        printArray(result);
    }

    // initial method to call merge sort array method
    public static int[] sortArray(int[] arrToSort) {
        int length = arrToSort.length;
        return mergeSortArr(arrToSort,  0, length - 1);
    }

    // method which breaks array into two half and sends for sorting.
    // This will be a recursive call function.
    public static int[] mergeSortArr(int[] arr, int start, int end) {
        if(start < end) {
            int mid = start + ((end - start)/2);
            mergeSortArr(arr, start, mid);
            mergeSortArr(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }

    private static void merge(int[] arr, int start, int m, int end) {
        int leftLength = m - start + 1; // left array length
        int rightLength = end - m; // right array length

        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

        // Create new left array
        for(int i = 0; i < leftLength; ++i) {
            L[i] = arr[start + i];
        }

        // Create new right array
        for(int j = 0; j < rightLength; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = start;

        while(i < leftLength && j < rightLength) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy what is left in left sub array
        while(i < leftLength) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // copy what is left in right sub array
        while(j < rightLength) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(String.format("The value of array at position [%s] is - %s", i, arr[i]));
        }
    }
}
