
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringConcatenationAndFileReader {

    public static void main(String[] args) {
        // Task 1: Compare StringBuilder vs StringBuffer performance for string concatenation

        String str = "hello";  // String to concatenate
        int times = 1000000;    // Number of times to concatenate

        // Measure time taken for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure time taken for StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) / 1_000_000 + " ms");

        // Task 2: Count words in a large file using FileReader and InputStreamReader

        String filePath = "path_to_large_file.txt";  // Replace with the actual file path
        System.out.println("Counting words in the file...");

        long wordCount = countWordsInFile(filePath);
        System.out.println("Total number of words in the file: " + wordCount);
    }

    // Function to count words in the file
    public static long countWordsInFile(String filePath) {
        long wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileReader);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words using whitespace as delimiter
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return wordCount;
    }
}
