import java.util.Stack;


class SortStack {
    // Main function to sort the stack
    public static void sort(Stack<Integer> stack) {
        // Base case: if the stack is not empty
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();
            
            // Recursively sort the remaining stack
            sort(stack);
            
            // Insert the popped element back into the sorted stack
            insertSorted(stack, temp);
        }
    }


    // Helper function to insert an element in the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // If the stack is empty or the element is greater than the top element, push the element
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
        } else {
            // Otherwise, pop the top element and recursively insert the element
            int temp = stack.pop();
            insertSorted(stack, element);
            
            // Push the popped element back into the stack
            stack.push(temp);
        }
    }


    // Function to print the stack
    public static void printStack(Stack<Integer> stack) {
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Adding some elements to the stack
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(50);
        stack.push(40);
        
        System.out.println("Original Stack:");
        printStack(stack);
        
        // Sorting the stack
        sort(stack);
        
        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}
