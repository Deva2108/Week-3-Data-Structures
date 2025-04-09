public class MatrixBinarySearch {

    // Function to search a target value in a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Empty matrix case
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1; // Treating the matrix as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle index
            int midValue = matrix[mid / cols][mid % cols]; // Convert 1D index to 2D index

            if (midValue == target) {
                return true; // Target found
            } else if (midValue < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 5; // Example target

        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);

        target = 20; // Example target that is not in the matrix
        result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
