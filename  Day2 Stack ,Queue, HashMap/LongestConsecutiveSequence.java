import java.util.HashSet;


public class LongestConsecutiveSequence {
    // Function to find the length of the longest consecutive elements sequence
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  // Return 0 if the array is empty
        }
        
        // Use a hash set to store the elements for O(1) lookup time
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        // Iterate through each element in the array
        for (int num : numSet) {
            // Only start counting if num - 1 is not in the set (i.e., it's the start of a sequence)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Count the consecutive sequence starting from currentNum
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                // Update the longest streak if needed
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        
        // Find the length of the longest consecutive sequence
        int result = longestConsecutive(nums);
        System.out.println("The length of the longest consecutive sequence is: " + result);
    }
}
