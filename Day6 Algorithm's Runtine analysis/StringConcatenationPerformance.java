public class StringConcatenationPerformance {
    
    public static void main(String[] args) {
        int n = 1000000;  // Number of strings to concatenate
        String str = "Hello";  // String to concatenate
        String[] stringArray = new String[n];

        // Fill array with the same string
        for (int i = 0; i < n; i++) {
            stringArray[i] = str;
        }

        // Measure time for String concatenation
        long startTime = System.nanoTime();
        String resultString = "";
        for (int i = 0; i < n; i++) {
            resultString += stringArray[i];  // Concatenate using String (inefficient)
        }
        long endTime = System.nanoTime();
        long stringTime = endTime - startTime;

        // Measure time for StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(stringArray[i]);  // Concatenate using StringBuilder (efficient)
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        // Measure time for StringBuffer concatenation
        startTime = System.nanoTime();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(stringArray[i]);  // Concatenate using StringBuffer (thread-safe)
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // Output results
        System.out.println("String concatenation time: " + stringTime / 1000000.0 + " ms");
        System.out.println("StringBuilder concatenation time: " + stringBuilderTime / 1000000.0 + " ms");
        System.out.println("StringBuffer concatenation time: " + stringBufferTime / 1000000.0 + " ms");
    }
}

