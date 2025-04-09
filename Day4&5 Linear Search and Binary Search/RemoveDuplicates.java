import java.util.HashSet;

public class RemoveDuplicates {

    // Method to remove duplicate characters using StringBuilder
    public static String removeDuplicates(String input) {
        // Initialize a StringBuilder to build the result string
        StringBuilder result = new StringBuilder();
        
        // Initialize a HashSet to track characters we've already added
        HashSet<Character> seen = new HashSet<>();
        
        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // If the character is not in the HashSet, add it to result
            if (!seen.contains(currentChar)) {
                result.append(currentChar);
                seen.add(currentChar);  // Add the character to the HashSet
            }
        }
        
        // Return the result string as a regular string
        return result.toString();
    }

    // Main method to test the removeDuplicates function
    public static void main(String[] args) {
        String input = "programming";  // Example input string
        
        System.out.println("Original String: " + input);
        
        // Call the removeDuplicates method and print the result
        String output = removeDuplicates(input);
        System.out.println("String without duplicates: " + output);
    }
}
