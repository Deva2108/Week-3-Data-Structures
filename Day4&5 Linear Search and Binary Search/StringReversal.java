public class StringReversal {

    // Method to reverse the given string using StringBuilder
    public static String reverseString(String input) {
        // Step 1: Create a new StringBuilder object
        StringBuilder stringBuilder = new StringBuilder();

        // Step 2: Append the input string to the StringBuilder
        stringBuilder.append(input);

        // Step 3: Use the reverse() method to reverse the string
        stringBuilder.reverse();

        // Step 4: Convert the StringBuilder back to a string and return it
        return stringBuilder.toString();
    }

    // Main method to test the string reversal
    public static void main(String[] args) {
        String input = "hello";  // Example input string
        
        System.out.println("Original String: " + input);
        
        // Call the reverseString method and print the result
        String reversedString = reverseString(input);
        System.out.println("Reversed String: " + reversedString);
    }
}
