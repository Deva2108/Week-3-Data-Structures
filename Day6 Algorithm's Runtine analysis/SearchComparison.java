import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the target, return its index
            }
        }
        return -1; // Target not found
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found the target, return its index
            }
            if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    // Helper function to generate a random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10); // Random integers up to size * 10
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; // Dataset sizes to test
        int target = 123456; // Arbitrary target number for search tests

        for (int size : sizes) {
            // Generate random array for linear search
            int[] linearArray = generateRandomArray(size);
            
            // Measure time for Linear Search
            long startTime = System.nanoTime();
            linearSearch(linearArray, target);
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;

            // Generate sorted array for binary search
            int[] binaryArray = Arrays.copyOf(linearArray, size);
            Arrays.sort(binaryArray); // Sort the array

            // Measure time for Binary Search
            startTime = System.nanoTime();
            binarySearch(binaryArray, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;

            // Convert to milliseconds for display
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + " ms");
            System.out.println("------------------------------------------");
        }
    }
}
