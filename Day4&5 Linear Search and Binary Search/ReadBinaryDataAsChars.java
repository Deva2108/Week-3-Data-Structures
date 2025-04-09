import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadBinaryDataAsChars {

    public static void main(String[] args) {
        // Define the path to the file and the charset to decode the binary data (e.g., UTF-8)
        String filePath = "path_to_your_file.txt"; // Replace with the actual file path
        String charset = "UTF-8"; // Specify the charset, such as UTF-8

        // Initialize FileInputStream, InputStreamReader, and BufferedReader
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Create a FileInputStream to read the binary data from the file
            fileInputStream = new FileInputStream(filePath);

            // Wrap the FileInputStream in an InputStreamReader to decode bytes into characters using the specified charset
            inputStreamReader = new InputStreamReader(fileInputStream, charset);

            // Wrap the InputStreamReader in a BufferedReader to read the file line by line efficiently
            bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line as characters
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle file reading or encoding errors
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            // Close the resources to release file handles and avoid memory leaks
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}
