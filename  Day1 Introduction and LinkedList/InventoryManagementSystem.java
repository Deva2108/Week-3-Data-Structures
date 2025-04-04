class Item {
    String name;
    String id;
    int quantity;
    double price;
    Item next;

    Item(String name, String id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }   
}

class ItemLinkedList {
    Item head;

    public void addAtBeginning(String name, String id, int quantity, double price) {
        Item item = new Item(name, id, quantity, price);

        if(head == null) {
            head = item;
            return;
        }

        item.next = head;
        head = item.next;
    }

    public void addAtEnd(String name, String id, int quantity, double price) {
        Item item = new Item(name, id, quantity, price);

        if(head == null) {
            head = item;
            return;
        }

        Item temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = item;
    }

    public void addAtPosition(int position, String name, String id, int quantity, double price) {
        if(position == 0) {
            addAtBeginning(name, id, quantity, price);
            return;
        }

        Item newItem = new Item(name, id, quantity, price);

        Item temp = head;
        int cnt = 0;
        while(cnt < position - 1 && temp != null) {
            temp = temp.next;
            cnt++;
        }

        if(temp == null) {
            System.out.println("Position doesnt exist");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItemByItemId(String id) {
        if(head == null) return;

        if(head.id == id) {
            head = head.next;
            return;
        }

        Item temp = head;
        while(!temp.id.equals(id) && temp != null) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student with roll number " + id + " not found ");
            return;
        }

        temp.next = temp.next.next;
    }

    public void searchById(String id) {
        Item temp = head;
        while(temp !=  null) {
            if(temp.id.equals(id)) {
                System.out.println("Found: ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with Id " + id + " not found.");
    }

    public void updateQuantityById(String id, int newQuantity) {
        Item temp = head;
        while(!temp.id.equals(id) && temp != null) {
            temp = temp.next;
        }

        if(temp == null) {
            System.out.println("Id doesn't exists");
        }
        
        temp.quantity = newQuantity;
    }

    public void displayAll() {
        Item temp = head;
        if (temp == null) {
            System.out.println("No item records found.");
            return;
        }
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", ID: " + temp.id + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

class InventoryManagementSystem {
    public static void main(String[] args) {
        ItemLinkedList list = new ItemLinkedList();

        list.addAtBeginning("Banana", "123", 10, 2);
        list.addAtEnd("Apple", "124", 5, 5);
        list.addAtPosition(1, "Grapes", "125", 10, 1);

        System.out.println("All Items:");
        list.displayAll();

        System.out.println("\nSearching for Id number 124:");
        list.searchById("124");

        System.out.println("\nUpdating grade for item Id 123:");
        list.updateQuantityById("123", 25);

        System.out.println("\nAll Items After Update:");
        list.displayAll();

        System.out.println("\nDeleting Item with Id 123:");
        list.removeItemByItemId("123");

        System.out.println("\nAll Items After Deletion:");
        list.displayAll();
    }
}
