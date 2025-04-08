public class InsertionSort {

    // Method to perform Insertion Sort on the given array
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        
        // Traverse through all elements of the array starting from the second element
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];  // The current element to insert into the sorted part
            int j = i - 1;  // Index of the last element of the sorted part
            
            // Shift elements of the sorted part that are greater than the key to one position ahead
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            
            // Insert the key in the correct position in the sorted part
            employeeIds[j + 1] = key;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the insertion sort
    public static void main(String[] args) {
        int[] employeeIds = {101, 104, 102, 106, 105, 103};  // Example employee IDs
        
        System.out.println("Original Employee IDs:");
        printArray(employeeIds);  // Print original employee IDs
        
        insertionSort(employeeIds);  // Sort the employee IDs using insertion sort
        
        System.out.println("Sorted Employee IDs in Ascending Order:");
        printArray(employeeIds);  // Print sorted employee IDs
    }
}
