
public class FirstNegativeNumberSearch {

    // Function to perform Linear Search to find the first negative number
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array from the start
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number
            }
        }
        return -1; // If no negative number is found, return -1
    }

    public static void main(String[] args) {
        // Sample input array
        int[] arr = {10, 15, 30, -5, 20, -3, 25};

        // Call the function and get the index of the first negative number
        int index = findFirstNegative(arr);

        // Output the result
        if (index != -1) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }
}
