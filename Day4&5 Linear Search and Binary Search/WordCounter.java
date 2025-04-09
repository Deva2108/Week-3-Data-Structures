import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

    public static void main(String[] args) {
        // Define the target word to search for in the file
        String targetWord = "the";  // Change this to the word you want to search
        String filePath = "path_to_your_file.txt";  // Replace with your file path
        
        // Initialize the counter
        int wordCount = 0;
        
        // Initialize FileReader and BufferedReader
        BufferedReader reader = null;

        try {
            // Create a FileReader to read from the file
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap the FileReader in a BufferedReader for efficient line-by-line reading
            reader = new BufferedReader(fileReader);

            String line;
            
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase to make the search case-insensitive
                String[] words = line.toLowerCase().split("\\s+");

                // Count occurrences of the target word in the current line
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        wordCount++;
                    }
                }
            }

            // Output the final count of the word
            System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            // Handle any file reading errors
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Ensure that the BufferedReader is closed to release resources
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
