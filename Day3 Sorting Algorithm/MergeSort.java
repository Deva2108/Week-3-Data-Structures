public class MergeSort {

    // Method to perform Merge Sort on the given array
    public static void mergeSort(int[] prices) {
        if (prices.length < 2) {
            return; // Base case: an array of length 0 or 1 is already sorted
        }
        
        // Find the middle of the array
        int mid = prices.length / 2;

        // Divide the array into two halves
        int[] left = new int[mid];
        int[] right = new int[prices.length - mid];

        // Copy data into left and right subarrays
        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);

        // Recursively sort the two halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(prices, left, right);
    }

    // Method to merge two sorted subarrays into a single sorted array
    private static void merge(int[] prices, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }

        // If there are remaining elements in left array
        while (i < left.length) {
            prices[k++] = left[i++];
        }

        // If there are remaining elements in right array
        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the merge sort
    public static void main(String[] args) {
        int[] bookPrices = {500, 300, 150, 700, 200, 450};  // Example book prices
        
        System.out.println("Original Book Prices:");
        printArray(bookPrices);  // Print original prices
        
        mergeSort(bookPrices);  // Sort the prices using merge sort
        
        System.out.println("Sorted Book Prices in Ascending Order:");
        printArray(bookPrices);  // Print sorted prices
    }
}
