import java.util.Stack;


class QueueUsingStacks {
    private Stack<Integer> inStack;  // Stack used for enqueue operations
    private Stack<Integer> outStack; // Stack used for dequeue operations


    // Constructor
    public QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }


    // Enqueue operation
    public void enqueue(int x) {
        inStack.push(x); // Push element to inStack
        System.out.println(x + " enqueued to queue");
    }


    // Dequeue operation
    public int dequeue() {
        // If outStack is empty, move all elements from inStack to outStack
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }


        // If both stacks are empty, the queue is empty
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;  // Indicating queue is empty
        }


        // Pop the top element from outStack, which is the front of the queue
        return outStack.pop();
    }


    // Peek operation (return the front of the queue without removing it)
    public int peek() {
        // If outStack is empty, move all elements from inStack to outStack
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }


        // If both stacks are empty, the queue is empty
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;  // Indicating queue is empty
        }


        // Return the top element from outStack, which is the front of the queue
        return outStack.peek();
    }


    // Check if the queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


    // Return the size of the queue
    public int size() {
        return inStack.size() + outStack.size();
    }
}


public class Main {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();


        // Perform some operations
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);


        System.out.println("Dequeued: " + queue.dequeue()); // Should print 1
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 2


        queue.enqueue(4);
        System.out.println("Peek: " + queue.peek()); // Should print 3


        System.out.println("Dequeued: " + queue.dequeue()); // Should print 3
        System.out.println("Dequeued: " + queue.dequeue()); // Should print 4


        // Attempt to dequeue from an empty queue
        System.out.println("Dequeued: " + queue.dequeue()); // Should indicate queue is empty
    }
}


