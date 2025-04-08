public class CountingSort {

    // Method to perform Counting Sort on the given array of student ages
    public static void countingSort(int[] ages) {
        // Define the range of ages (10 to 18)
        int minAge = 10;
        int maxAge = 18;

        // Step 1: Create a count array to store the frequency of each age
        int[] count = new int[maxAge - minAge + 1];

        // Step 2: Count the occurrences of each age in the input array
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        // Step 3: Modify the count array to store cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Create an output array to store the sorted ages
        int[] output = new int[ages.length];

        // Step 5: Place each age in its correct position in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Step 6: Copy the sorted output array to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the counting sort
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 18, 10, 14, 17, 16, 13, 11, 15};  // Example ages of students
        
        System.out.println("Original Student Ages:");
        printArray(studentAges);  // Print original student ages
        
        countingSort(studentAges);  // Sort the student ages using counting sort
        
        System.out.println("Sorted Student Ages in Ascending Order:");
        printArray(studentAges);  // Print sorted student ages
    }
}
