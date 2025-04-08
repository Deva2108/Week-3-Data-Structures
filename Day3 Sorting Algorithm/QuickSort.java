public class QuickSort {

    // Method to perform Quick Sort on the given array
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Find the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively apply quick sort to left and right subarrays
            quickSort(prices, low, pivotIndex - 1);  // Left part
            quickSort(prices, pivotIndex + 1, high); // Right part
        }
    }

    // Method to partition the array around a pivot
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choose the last element as the pivot
        int i = low - 1;  // Index of smaller element
        
        // Traverse through all elements, comparing each one to the pivot
        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                swap(prices, i, j);
            }
        }
        
        // Swap the pivot with the element at i + 1
        swap(prices, i + 1, high);
        
        // Return the pivot index
        return i + 1;
    }

    // Method to swap two elements in the array
    private static void swap(int[] prices, int i, int j) {
        int temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the quick sort
    public static void main(String[] args) {
        int[] productPrices = {500, 300, 150, 700, 200, 450};  // Example product prices
        
        System.out.println("Original Product Prices:");
        printArray(productPrices);  // Print original prices
        
        quickSort(productPrices, 0, productPrices.length - 1);  // Sort the prices using quick sort
        
        System.out.println("Sorted Product Prices in Ascending Order:");
        printArray(productPrices);  // Print sorted prices
    }
}
