public class ConcatenateStrings {

    // Method to concatenate all strings in the array using StringBuffer
    public static String concatenateStrings(String[] array) {
        // Create a new StringBuffer object to hold the result
        StringBuffer result = new StringBuffer();
        
        // Iterate through each string in the array and append it to the StringBuffer
        for (String str : array) {
            result.append(str);
        }
        
        // Return the concatenated result as a regular string
        return result.toString();
    }

    // Main method to test the concatenation
    public static void main(String[] args) {
        // Example array of strings
        String[] stringArray = {"Hello", " ", "World", "!", " How", " are", " you?"};
        
        // Call the concatenateStrings method and print the result
        String concatenatedString = concatenateStrings(stringArray);
        System.out.println("Concatenated String: " + concatenatedString);
    }
}
