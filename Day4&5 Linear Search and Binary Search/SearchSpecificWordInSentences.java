public class SearchSpecificWordInSentences {

    // Function to perform Linear Search to find the first sentence containing the specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through the array of sentences
        for (String sentence : sentences) {
            // Check if the current sentence contains the word
            if (sentence.contains(word)) {
                return sentence; // Return the sentence if it contains the word
            }
        }
        return "Not Found"; // If no sentence contains the word, return "Not Found"
    }

    public static void main(String[] args) {
        // Sample input array of sentences
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a programming language.",
            "I love solving coding problems.",
            "Linear search is useful for small datasets."
        };

        // Specific word to search for
        String word = "Java";

        // Call the function and get the sentence containing the word
        String result = findSentenceWithWord(sentences, word);

        // Output the result
        System.out.println(result);
    }
}
