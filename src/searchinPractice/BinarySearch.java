package searchinPractice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 18, 19, 34, 40, 67, 71, 89, 93};
        printArray(arr);
        int index = binarySearch(arr, 40);
        if(index < 0) {
            System.out.println("Item is not present in array");
        }
        else {
            System.out.println("Index of the searched integer in the array is - " + index);
        }
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(String.format("The value of array at position [%s] is - %s", i, arr[i]));
        }
    }

    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + ((end-start)/2);
            if(key == arr[mid]) {
                return mid;
            }
            if(key < arr[mid]) {
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
