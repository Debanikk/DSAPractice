package com.wildfire.PracticeSetAugust;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {3,2,4,3};
        getIntegerSets(nums, 6);
    }

    // Sum of two array index values is equals to provided integer
    public static void getIntegerSets(int[] arr, int sum)  {
        // --- My Exam solution --
        // 1. initialize list for return
        // 2. sort the array
        // 3. start iterating the array from the right end
        // 4. check if it is less than the sum - if then add the index to a hashset,
        // 5. get the remainder of the sum and the arr[i]
        // 6. check if the previous index or i-1 is higher or less than the remainder.
        // 7. if less than add the index else return from the iteration
        // 8. check remainder value if 0 then add the hashset to teh list else go on iterating

        // --- Actual Solution ---
        // 1. Create a hashmap
        // 2. Iterate array and store remainder in temp variable
        // 3. check if remainder is saved as key in hashmap
        // 4. if not store the array value as key and array index as value in hashmap
        // 5. if yes then print current index and stored index from hashmap and add new array index & value to map
        // 6. continue searching for more combination till the end of array.

        HashMap<Integer, Integer> s = new HashMap();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            // checking for condition
            if (s.containsKey(temp)) {
                System.out.println("Pair index are - " + i + " and " + s.get(temp));
                System.out.println("Yes");
            }
            s.put(arr[i], i);
        }
        System.out.println("No");
    }
}
