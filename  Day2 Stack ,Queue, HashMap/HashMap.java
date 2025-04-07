class HashMap {
    // Define the size of the hash map (the array size)
    private static final int SIZE = 10;
    
    // Array of linked lists (buckets)
    private LinkedList<Node>[] table;
    
    // Constructor to initialize the hash map
    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    // Hash function to compute the index for a given key
    private int hash(String key) {
        return key.hashCode() % SIZE;
    }
    
    // Method to insert a key-value pair
    public void insert(String key, String value) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];
        
        // Check if the key already exists and update it if so
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        
        // If the key does not exist, add a new node to the linked list
        bucket.add(new Node(key, value));
    }
    
    // Method to delete a key-value pair by key
    public void delete(String key) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];
        
        // Iterate through the bucket's linked list and remove the node if found
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }
    
    // Method to retrieve the value associated with a given key
    public String get(String key) {
        int index = hash(key);
        LinkedList<Node> bucket = table[index];
        
        // Search for the key in the bucket's linked list
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        
        // Return null if the key is not found
        return null;
    }
    
    // Node class representing a key-value pair in the hash map
    private static class Node {
        String key;
        String value;
        
        // Constructor to create a new node
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // Main method to demonstrate the hash map operations
    public static void main(String[] args) {
        HashMap map = new HashMap();
        
        // Insert some key-value pairs
        map.insert("name", "Alice");
        map.insert("age", "30");
        map.insert("city", "New York");
        
        // Retrieve values by key
        System.out.println("Name: " + map.get("name"));  // Output: Alice
        System.out.println("Age: " + map.get("age"));    // Output: 30
        System.out.println("City: " + map.get("city"));  // Output: New York
        
        // Update a value
        map.insert("city", "Los Angeles");
        System.out.println("Updated City: " + map.get("city"));  // Output: Los Angeles
        
        // Delete a key-value pair
        map.delete("age");
        System.out.println("Age after deletion: " + map.get("age"));  // Output: null
    }
}
