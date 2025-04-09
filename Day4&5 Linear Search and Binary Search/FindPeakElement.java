public class FindPeakElement {

    // Function to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak element
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }
            // If the middle element is smaller than the next element, peak must be in the right half
            else if (mid < arr.length - 1 && arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            }
            // If the middle element is smaller than the previous element, peak must be in the left half
            else {
                right = mid - 1;
            }
        }
        
        // Return -1 if no peak is found (this should not happen for a valid array)
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};  // Example array
        int peakIndex = findPeakElement(arr);
        
        // Output the peak element and its index
        System.out.println("Peak element is at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
