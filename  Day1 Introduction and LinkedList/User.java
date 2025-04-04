import java.util.ArrayList;
import java.util.HashSet;


class User {
    int userID;
    String name;
    int age;
    User next;  // Pointer to the next user in the singly linked list
    ArrayList<Integer> friends;  // List of Friend IDs


    // Constructor to initialize the user
    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}


class SocialMedia {
    private User head;


    public SocialMedia() {
        head = null;
    }


    // Add a user to the system
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }


    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);


        if (user1 != null && user2 != null) {
            if (!user1.friends.contains(userID2)) {
                user1.friends.add(userID2);
            }
            if (!user2.friends.contains(userID1)) {
                user2.friends.add(userID1);
            }
            System.out.println("Friendship added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }


    // Remove a friend connection between two users
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);


        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userID2));
            user2.friends.remove(Integer.valueOf(userID1));
            System.out.println("Friendship removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }


    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUser(userID1);
        User user2 = findUser(userID2);


        if (user1 != null && user2 != null) {
            HashSet<Integer> mutualFriends = new HashSet<>(user1.friends);
            mutualFriends.retainAll(user2.friends);  // Find intersection of both lists
            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends between " + user1.name + " and " + user2.name);
            } else {
                System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }


    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUser(userID);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        } else {
            System.out.println("User not found.");
        }
    }


    // Search for a user by Name or User ID
    public User searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public User searchUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    // Count the number of friends for a user
    public int countFriends(int userID) {
        User user = findUser(userID);
        if (user != null) {
            return user.friends.size();
        }
        return 0;
    }


    // Helper method to find a user by ID
    private User findUser(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    // Display all users in the system
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();


        // Add users to the system
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);
        sm.addUser(4, "David", 22);


        // Display all users
        System.out.println("All Users:");
        sm.displayAllUsers();


        // Add friends
        sm.addFriend(1, 2);  // Alice and Bob
        sm.addFriend(1, 3);  // Alice and Charlie
        sm.addFriend(2, 3);  // Bob and Charlie


        // Display friends of Alice
        sm.displayFriends(1);


        // Find mutual friends between Alice and Bob
        sm.findMutualFriends(1, 2);


        // Remove a friend connection between Alice and Bob
        sm.removeFriend(1, 2);


        // Display friends of Alice after removal
        sm.displayFriends(1);


        // Count friends of Alice
        System.out.println("Alice has " + sm.countFriends(1) + " friends.");


        // Search for a user by name
        User user = sm.searchUser("Charlie");
        if (user != null) {
            System.out.println("Found user: " + user.name);
        } else {
            System.out.println("User not found.");
        }


        // Search for a user by ID
        user = sm.searchUser(4);
        if (user != null) {
            System.out.println("Found user: " + user.name);
        } else {
            System.out.println("User not found.");
        }
    }
}
