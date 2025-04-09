public class BinarySearchFirstLast {

    // Function to find the first occurrence of the target
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Keep searching towards the left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to find the last occurrence of the target
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Keep searching towards the right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to find both the first and last occurrences of the target
    public static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);
        result[1] = findLastOccurrence(arr, target);

        return result;
    }

    public static void main(String[] args) {
        // Example sorted array
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 7};

        int target = 2;
        int[] result = findFirstAndLast(arr, target);

        if (result[0] == -1) {
            System.out.println("Target " + target + " not found.");
        } else {
            System.out.println("First occurrence of " + target + ": " + result[0]);
            System.out.println("Last occurrence of " + target + ": " + result[1]);
        }

        // Example of a target not found in the array
        target = 8;
        result = findFirstAndLast(arr, target);

        if (result[0] == -1) {
            System.out.println("Target " + target + " not found.");
        }
    }
}
