package sortingPractice;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        System.out.println("Value of array before sort is - ");
        printArray(arr);
        System.out.println("Value of array after sort is - ");
        int[] result = sortArray(arr);
        printArray(result);
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(String.format("The value of array at position [%s] is - %s", i, arr[i]));
        }
    }

    public static int[] sortArray(int[] arrToSort) {
        int length = arrToSort.length;
        return quickSort(arrToSort,  0, length - 1);
    }

    private static int[] quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, 0, p - 1);
            quickSort(arr, p + 1, end);
        }
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for(int j = start; j < end; j++){
            if(arr[j] <= pivot) {
                int temp1 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp1;
                i++;
            }
        }

        int temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = temp2;

        return i;
    }
}
