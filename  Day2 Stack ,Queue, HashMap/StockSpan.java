import java.util.Stack;


class StockSpan {
    // Function to calculate the stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Array to store the span for each day
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of prices


        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the price is greater than or equal to the stack's top
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }


            // If the stack is empty, the price is greater than all previous prices
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }


            // Push the current index to the stack
            stack.push(i);
        }


        return span;
    }


    // Function to print the span array
    public static void printSpan(int[] span) {
        for (int s : span) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        
        System.out.println("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
        
        // Calculate the span for each day
        int[] span = calculateSpan(prices);
        
        System.out.println("Stock Span for each day: ");
        printSpan(span);
    }
}


