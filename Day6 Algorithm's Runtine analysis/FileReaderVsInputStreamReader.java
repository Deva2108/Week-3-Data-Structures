import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) throws IOException {
        // File path for testing
        String filePath = "large_file.txt";  // Use a large file, e.g., 500MB or more for testing

        // Testing FileReader performance
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            while (fileReader.read(buffer) != -1) {
                // Just reading the file
            }
        }
        long endTime = System.nanoTime();
        long fileReaderTime = (endTime - startTime) / 1000000; // Convert to milliseconds
        System.out.println("FileReader Time: " + fileReaderTime + " ms");

        // Testing InputStreamReader performance
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[1024];
            while (inputStreamReader.read(buffer) != -1) {
                // Just reading the file
            }
        }
        endTime = System.nanoTime();
        long inputStreamReaderTime = (endTime - startTime) / 1000000; // Convert to milliseconds
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
    }
}
