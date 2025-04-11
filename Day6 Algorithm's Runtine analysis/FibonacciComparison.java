public class FibonacciComparison {
    
    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Main method to compare performance
    public static void main(String[] args) {
        int n = 30;  // You can test different values of n like 10, 30, or 50
        
        // Test Recursive Fibonacci
        long startTime = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = (endTime - startTime) / 1000000;  // Convert to milliseconds
        System.out.println("Recursive Fibonacci result for n = " + n + ": " + resultRecursive);
        System.out.println("Recursive Fibonacci time: " + recursiveTime + " ms");
        
        // Test Iterative Fibonacci
        startTime = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = (endTime - startTime) / 1000000;  // Convert to milliseconds
        System.out.println("Iterative Fibonacci result for n = " + n + ": " + resultIterative);
        System.out.println("Iterative Fibonacci time: " + iterativeTime + " ms");
    }
}
