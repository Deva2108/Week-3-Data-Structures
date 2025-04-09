
public class SearchAlgorithms {

    // Linear search to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and zeros with n+1
        // because the smallest missing positive integer will be in the range 1 to n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Use the indices as a hash map to mark presence
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark the number as visited
            }
        }

        // Step 3: Find the first index with a positive value
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // First missing positive number
            }
        }

        // If all positions are filled, the missing number is n + 1
        return n + 1;
    }

    // Binary search to find the index of the target number in a sorted array
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target, return its index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Example array for Linear Search (to find first missing positive)
        int[] nums1 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + findFirstMissingPositive(nums1));

        // Example sorted array for Binary Search (to find target index)
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        System.out.println("Index of " + target + ": " + binarySearch(nums2, target));

        // Example when target is not found in the sorted array
        target = 10;
        System.out.println("Index of " + target + ": " + binarySearch(nums2, target));
    }
}
