import java.util.*;

public class SearchComparison {

    public static void main(String[] args) {
        // Dataset sizes for comparison
        int[] datasetSizes = {1000, 100000, 1000000};
        
        for (int size : datasetSizes) {
            // Create datasets
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Fill the datasets with values
            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            // Search target
            int target = size / 2;

            // Measure Array Search
            long startTime = System.nanoTime();
            linearSearch(array, target);
            long endTime = System.nanoTime();
            long arraySearchTime = (endTime - startTime) / 1000000; // Convert to milliseconds
            System.out.println("Array search time for N=" + size + ": " + arraySearchTime + " ms");

            // Measure HashSet Search
            startTime = System.nanoTime();
            hashSet.contains(target);
            endTime = System.nanoTime();
            long hashSetSearchTime = (endTime - startTime) / 1000000;
            System.out.println("HashSet search time for N=" + size + ": " + hashSetSearchTime + " ms");

            // Measure TreeSet Search
            startTime = System.nanoTime();
            treeSet.contains(target);
            endTime = System.nanoTime();
            long treeSetSearchTime = (endTime - startTime) / 1000000;
            System.out.println("TreeSet search time for N=" + size + ": " + treeSetSearchTime + " ms");
            
            System.out.println("----------------------------------------");
        }
    }

    // Linear search function for array
    public static boolean linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            }
        }
        return false;
    }
}
