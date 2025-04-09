public class FindRotationPoint {

    // Function to find the index of the smallest element in the rotated sorted array
    public static int findMinIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the right element, 
            // the smallest element must be to the right of mid
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest element is to the left of mid, including mid
                right = mid;
            }
        }
        
        // At the end of the loop, left == right and points to the smallest element
        return left;
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        
        // Find the index of the smallest element (rotation point)
        int index = findMinIndex(arr);
        
        // Output the result
        System.out.println("The index of the smallest element is: " + index);
        System.out.println("The smallest element is: " + arr[index]);
    }
}

