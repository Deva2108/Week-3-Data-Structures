import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {
        // Path to the text file
        String filePath = "path_to_your_file.txt"; // Replace with the actual file path

        // Initialize FileReader and BufferedReader
        BufferedReader reader = null;

        try {
            // Create a FileReader to read from the file
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap the FileReader in a BufferedReader to read lines efficiently
            reader = new BufferedReader(fileReader);

            String line;
            
            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Print the line to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle any file reading errors
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the BufferedReader and FileReader to release resources
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
