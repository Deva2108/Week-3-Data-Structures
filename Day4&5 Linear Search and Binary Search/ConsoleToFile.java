import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFile {

    public static void main(String[] args) {
        // Initialize InputStreamReader to read from console (System.in)
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        
        // Initialize FileWriter to write to a file
        FileWriter fileWriter = null;

        try {
            // Set up BufferedReader to read user input
            inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);

            // Set up FileWriter to write to a specific file (e.g., "output.txt")
            fileWriter = new FileWriter("output.txt", true); // 'true' to append to the file

            String userInput;

            // Prompt the user
            System.out.println("Enter text (type 'exit' to stop):");

            // Continuously read user input and write to the file until "exit" is typed
            while (true) {
                // Read a line of input from the user
                userInput = bufferedReader.readLine();

                // Check if the user typed "exit" to stop
                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Exit the loop if "exit" is entered
                }

                // Write the input to the file followed by a newline
                fileWriter.write(userInput + System.lineSeparator());
            }

            // Inform the user that the input has been saved
            System.out.println("Your input has been saved to the file.");

        } catch (IOException e) {
            // Handle any input or file errors
            System.out.println("An error occurred while reading or writing to the file: " + e.getMessage());
        } finally {
            // Close the resources (BufferedReader and FileWriter)
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing resources: " + e.getMessage());
            }
        }
    }
}
