public class HeapSort {

    // Method to perform Heap Sort on the given array
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap from the array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // One by one, extract elements from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            swap(salaries, 0, i);

            // Heapify the root element to restore heap property
            heapify(salaries, i, 0);
        }
    }

    // Method to maintain the heap property by heapifying a subtree
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    // Method to swap two elements in the array
    private static void swap(int[] salaries, int i, int j) {
        int temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the heap sort
    public static void main(String[] args) {
        int[] salaryDemands = {50000, 75000, 30000, 100000, 45000, 60000, 85000};  // Example salary demands
        
        System.out.println("Original Salary Demands:");
        printArray(salaryDemands);  // Print original salary demands
        
        heapSort(salaryDemands);  // Sort the salary demands using heap sort
        
        System.out.println("Sorted Salary Demands in Ascending Order:");
        printArray(salaryDemands);  // Print sorted salary demands
    }
}
