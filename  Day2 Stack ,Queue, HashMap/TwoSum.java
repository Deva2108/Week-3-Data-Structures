import java.util.HashMap;

public class TwoSum {
    // Method to find two indices whose values add up to the target sum
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate complement (target - current element)
            
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                // Return the indices of the current element and the complement
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current element and its index in the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        
        // Find the two indices
        int[] result = twoSum(nums, target);
        
        // Print the result
        if (result.length > 0) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
}

