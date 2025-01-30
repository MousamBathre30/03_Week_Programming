package findallSubarrayswithZeroSum;


import java.util.HashMap;
import java.util.*;

public class SubarraysWithZeroSum {
    public static void findSubarrays(int[] arr) {
        // HashMap to store (prefixSum -> list of indices where it appears)
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // Initialize the map with sum 0 at index -1 to handle subarrays starting from index 0
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        // Traverse the array and compute prefix sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the prefix sum exists in the map, it means we found subarrays with sum 0
            if (map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    System.out.println("Subarray found from index " + (startIdx + 1) + " to " + i);
                }
            }

            // Add the current sum to the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, 3, -2, -3, 3};
        findSubarrays(arr);
    }
}
