public class BubbleSort {

    // Method to perform Bubble Sort on the given array
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse the array n-1 times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;  // To check if any swapping occurred in the pass

            // Traverse the array from 0 to n-i-1 (elements after the sorted part)
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swap if the current element is greater than the next
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped in this pass, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the bubble sort
    public static void main(String[] args) {
        int[] studentMarks = {85, 70, 90, 60, 75, 95, 80};  // Example student marks
        
        System.out.println("Original Marks:");
        printArray(studentMarks);  // Print original marks
        
        bubbleSort(studentMarks);  // Sort the marks using bubble sort
        
        System.out.println("Sorted Marks in Ascending Order:");
        printArray(studentMarks);  // Print sorted marks
    }
}
