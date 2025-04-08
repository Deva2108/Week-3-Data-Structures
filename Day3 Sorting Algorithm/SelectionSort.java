public class SelectionSort {

    // Method to perform Selection Sort on the given array
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                swap(scores, i, minIndex);
            }
        }
    }

    // Method to swap two elements in the array
    private static void swap(int[] scores, int i, int j) {
        int temp = scores[i];
        scores[i] = scores[j];
        scores[j] = temp;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the selection sort
    public static void main(String[] args) {
        int[] examScores = {95, 83, 70, 100, 88, 78, 65};  // Example student scores
        
        System.out.println("Original Exam Scores:");
        printArray(examScores);  // Print original scores
        
        selectionSort(examScores);  // Sort the scores using selection sort
        
        System.out.println("Sorted Exam Scores in Ascending Order:");
        printArray(examScores);  // Print sorted scores
    }
}
