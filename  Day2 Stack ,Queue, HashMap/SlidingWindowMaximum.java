import java.util.Deque;
import java.util.LinkedList;


class SlidingWindowMaximum {
    // Function to find the maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];  // Edge case: empty array or invalid k
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];  // To store the maximums for each window
        Deque<Integer> deque = new LinkedList<>();  // To store indices of useful elements
        
        for (int i = 0; i < n; i++) {
            // Remove indices of elements that are out of the current window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }


            // Remove elements from the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }


            // Add the current element's index to the deque
            deque.offer(i);


            // If we have processed at least k elements, record the result for this window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }


        return result;
    }


    // Function to print the result
    public static void printResult(int[] result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;


        System.out.println("Input Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Find the maximum in each sliding window of size k
        int[] result = maxSlidingWindow(nums, k);


        System.out.println("Maximum in each sliding window: ");
        printResult(result);
    }
}
