import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSortHelper(arr, low, pivot - 1);
            quickSortHelper(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Helper function to generate a random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10); // Random integers up to size * 10
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000}; // Dataset sizes to test

        for (int size : sizes) {
            int[] originalArray = generateRandomArray(size);

            // Bubble Sort
            int[] bubbleArray = Arrays.copyOf(originalArray, size);
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;

            // Merge Sort
            int[] mergeArray = Arrays.copyOf(originalArray, size);
            startTime = System.nanoTime();
            mergeSort(mergeArray);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;

            // Quick Sort
            int[] quickArray = Arrays.copyOf(originalArray, size);
            startTime = System.nanoTime();
            quickSort(quickArray);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;

            // Output the times for each sorting algorithm
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleSortTime / 1000000.0 + " ms");
            System.out.println("Merge Sort Time: " + mergeSortTime / 1000000.0 + " ms");
            System.out.println("Quick Sort Time: " + quickSortTime / 1000000.0 + " ms");
            System.out.println("------------------------------------------");
        }
    }
}
