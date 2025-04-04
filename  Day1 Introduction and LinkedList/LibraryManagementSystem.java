class Book {
    private String title;
    private String author;
    private String genre;
    private String bookID;
    private boolean availability;

    Book next;
    Book prev;

    Book(String title, String author, String genre, String bookID) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.availability = true;
        prev = null;
        next = null;
    }
}

class BookList {
    private Book head;
    private Book tail;

    public void addAtBeginning(String title, String author, String genre, String bookID) {
        Book book = new Book(title, author, genre, bookID);
        if(head == null) {
            head = tail = null;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
    }

    public void addAtEnd(String title, String author, String genre, String bookID) {
        Book book = new Book(title, author, genre, bookID);
        if(tail == null) {
            head = tail = null;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
    }

    public void addAtPosition(int position, String title, String author, String genre, String bookID) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookID);
            return;
        }

        Book current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, author, genre, bookID);
        } else {
            Book newbook = new Book(title, author, genre, bookID);
            newbook.next = current.next;
            newbook.prev = current;
            newbook.next.prev = newbook;
            current.next = newbook;
        }
    }

    public void removeByTitle(String title) {
        
    }   
}

class LibraryManagementSystem {
    
}
